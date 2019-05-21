package Control;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import GameObjects.GameObject;
import GameObjects.GameObjectFactory;
import GameObjects.Statics;

public class GameController {
	Player player;
	List<GameObject> objects;
	GameObjectFactory factory;
	Random random;
	String[] types= {"Apple","Melon","Orange","FatalBomb","DangerBomb","Apple","Melon","Orange","FatalBomb","DangerBomb","Apple","Melon","Orange","FatalBomb","DangerBomb","SpecialFruit","DragonFruit","Mango","Mango"};
	
	int difficulty;
	int speedMin;
	int speedMax;
	int difficultyIterator;
	
	
	public GameController(int difficulty) {
		player= player.getInstance();
		objects=new ArrayList<GameObject>();
		factory=new GameObjectFactory();
		random=new Random();
		this.difficulty=difficulty;
	}
	
	public void slice(GameObject obj) {
		obj.slice();
		if(player.getLives()==0)
			player.setHasLost(true);
		
	}
	
	public void randomizeGameObjects()
	{
		objects.clear();
		if(difficulty==0)
		{
			speedMin=3;
			speedMax=5;
			difficultyIterator=3;
			Statics.arcade=false;
		}
		else if(difficulty==1)
		{
			speedMin=5;
			speedMax=6;
			difficultyIterator=4;
			Statics.arcade=false;
		}
		else if(difficulty==2)
		{
			speedMin=6;
			speedMax=8;
			difficultyIterator=5;
			Statics.arcade=false;
		}
		else if(difficulty==3)
		{
			speedMin=7;
			speedMax=9;
			difficultyIterator=5;
			Statics.arcade=true;
			player.setLives(0);
		}
		for(int i=0; i<difficultyIterator;i++)
		{
			objects.add(factory.makeGameObject(types[random.nextInt(5)], speedMin+random.nextInt(speedMax-speedMin),100+random.nextInt(200),300+random.nextInt(800),random.nextFloat()*(0.4f-0.2f)));
		}
		
		
	
	}

	public List<GameObject> getObjects() {
		return objects;
	}
	public GameObject createObject()
	{
		return factory.makeGameObject(types[random.nextInt(19)], speedMin+random.nextInt(speedMax-speedMin),100+random.nextInt(200),100+random.nextInt(800),random.nextFloat()*(0.4f-0.2f));
	}
	public Player getPlayer() {
		return player;
	}
	
	
	public void saveGame() {
		
		 
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.newDocument();

	         // root element
		    Element rootElement = doc.createElement("FruitNinja");
            doc.appendChild(rootElement);
		    
		    
		    
        	Element BananaScore = doc.createElement("HighScore");
            rootElement.appendChild(BananaScore);
            
            Attr attrType = doc.createAttribute("score");
            attrType.setValue(Integer.toString(player.getHighScore()));
            
            BananaScore.setAttributeNode(attrType);
            
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Fruit Ninja.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
            
          /*  Element PeachScore = doc.createElement("HighScorePeach");
            rootElement.appendChild(PeachScore);
            
            Attr attrType1 = doc.createAttribute("score");
            attrType1.setValue(Integer.toString(highScorePeach));
            
            PeachScore.setAttributeNode(attrType1);
            
            
            
            
            
            
            Element MelonScore = doc.createElement("HighScoreMelon");
            rootElement.appendChild(MelonScore);
            
            Attr attrType2 = doc.createAttribute("score");
            attrType2.setValue(Integer.toString(highScoreMelon));
            
            MelonScore.setAttributeNode(attrType2);
            
            
            
            
            Element ArcadeScore = doc.createElement("HighScoreArcade");
            rootElement.appendChild(ArcadeScore);
            
            Attr attrType3 = doc.createAttribute("score");
            attrType3.setValue(Integer.toString(highScoreArcade));
	         
            ArcadeScore.setAttributeNode(attrType3);
	         
	         
	         */
	         
	         
	         
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         
         
	}
	
	public void loadGame() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Fruit Ninja.xml");
			//NodeList CrossersOnLeftList = doc.getElementsByTagName("CrossersOnLeft");
			
			NodeList score1 = doc.getElementsByTagName("HighScore");
			Node score= score1.item(0); 
		
				if(score.getNodeType()==Node.ELEMENT_NODE) {
					Element s = (Element) score;
					 player.setHighScore( Integer.parseInt( s.getAttribute("score")));
					System.out.println("High Score Banana = " + player.getHighScore());
			}
				
				
				/*NodeList score2 = doc.getElementsByTagName("HighScorePeach");
				Node score22= score2.item(0); 
			
					if(score.getNodeType()==Node.ELEMENT_NODE) {
						Element s = (Element) score22;
						highScoreBanana = Integer.parseInt( s.getAttribute("score"));
						System.out.println("High Score Peach = " + highScorePeach);
				}	
				
					
					
					NodeList score3 = doc.getElementsByTagName("HighScoreMelon");
					Node score33= score3.item(0); 
				
						if(score.getNodeType()==Node.ELEMENT_NODE) {
							Element s = (Element) score33;
							highScoreBanana = Integer.parseInt( s.getAttribute("score"));
							System.out.println("High Score Melon = " + highScoreMelon);
					}	
			
						
						
						
						NodeList score4 = doc.getElementsByTagName("HighScoreArcade");
						Node score44= score4.item(0); 					
							if(score.getNodeType()==Node.ELEMENT_NODE) {
								Element s = (Element) score44;
								highScoreBanana = Integer.parseInt( s.getAttribute("score"));
								System.out.println("High Score Arcade = " + highScoreArcade);
						}	*/
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
