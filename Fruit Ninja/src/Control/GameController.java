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
	String[] types= {"Apple","Melon","Orange","FatalBomb","DangerBomb","Apple","Melon","Orange","FatalBomb","DangerBomb","Apple","Melon","Orange","FatalBomb","DangerBomb","SpecialFruit"};
	
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
		}
		else if(difficulty==1)
		{
			speedMin=5;
			speedMax=6;
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
			objects.add(factory.makeGameObject(types[random.nextInt(5)], speedMin+random.nextInt(speedMax-speedMin),100+random.nextInt(200),300+random.nextInt(800),random.nextFloat()*(0.4f-0.2f)));
		}
	
	}

	public List<GameObject> getObjects() {
		return objects;
	}
	public GameObject createObject()
	{
		return factory.makeGameObject(types[random.nextInt(16)], speedMin+random.nextInt(speedMax-speedMin),100+random.nextInt(200),100+random.nextInt(800),random.nextFloat()*(0.4f-0.2f));
	}
	public Player getPlayer() {
		return player;
	}
	
}
