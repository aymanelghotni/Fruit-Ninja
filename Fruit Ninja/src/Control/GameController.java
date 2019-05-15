package Control;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import GameObjects.GameObject;
import GameObjects.GameObjectFactory;

public class GameController {
	Player player;
	List<GameObject> objects;
	GameObjectFactory factory;
	Random random;
	String[] types= {"Apple","Melon","Orange","FatalBomb","DangerBomb"};
	
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
			speedMin=10;
			speedMax=15;
			difficultyIterator=3;
		}
		else if(difficulty==1)
		{
			speedMin=15;
			speedMax=20;
			difficultyIterator=4;
		}
		else if(difficulty==2)
		{
			speedMin=6;
			speedMax=8;
			difficultyIterator=5;
		}
		for(int i=0; i<difficultyIterator;i++)
		{
			objects.add(factory.makeGameObject(types[random.nextInt(5)], speedMin+random.nextInt(speedMax-speedMin),100+random.nextInt(200),100+random.nextInt(800)));
		}
	
	}

	public List<GameObject> getObjects() {
		return objects;
	}
	public GameObject createObject()
	{
		return factory.makeGameObject(types[random.nextInt(5)], speedMin+random.nextInt(speedMax-speedMin),100+random.nextInt(200),100+random.nextInt(800));
	}
	public Player getPlayer() {
		return player;
	}
	
}