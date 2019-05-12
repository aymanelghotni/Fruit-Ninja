import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
	Player player;
	List<GameObject> objects;
	GameObjectFactory factory;
	Random random;
	String[] types= {"Apple","Melon","Orange","FatalBomb","DangerBomb"};
	int difficulty;
	float speedMin;
	float speedMax;
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
			speedMin=0.15f;
			speedMax=0.35f;
			difficultyIterator=3;
		}
		else if(difficulty==1)
		{
			speedMin=0.2f;
			speedMax=0.4f;
			difficultyIterator=4;
		}
		else if(difficulty==2)
		{
			speedMin=0.25f;
			speedMax=0.45f;
			difficultyIterator=5;
		}
		for(int i=0; i<difficultyIterator;i++)
		{
			objects.add(factory.makeGameObject(types[random.nextInt(4)], speedMin+random.nextFloat()*(speedMax-speedMin)));
		}
	
	}
}
