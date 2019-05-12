import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
	Player player;
	List<GameObject> objects;
	GameObjectFactory factory;
	Random random;
	
	
	public GameController() {
		player=player.getInstance();
		objects=new ArrayList<GameObject>();
		factory=new GameObjectFactory();
		random=new Random();
	}
	
	public void slice(GameObject obj) {
		obj.isSliced=true;
		if(obj instanceof FatalBomb)
		{
			player.setLives(0);
		}
		if(obj instanceof DangerBomb)
		{
			player.setLives(player.getLives()-1);
		}
		if(obj instanceof Orange || obj instanceof Melon || obj instanceof Apple)
		{
			player.setScore(player.getScore()+10);
		}
		
	}
	
	public void randomizeGameObjects()
	{
		objects.clear();
		
		objects.add(factory.makeGameObject("Melon", 0.15f+random.nextFloat()*(0.2f)));
		objects.add(factory.makeGameObject("Apple", 0.15f+random.nextFloat()*(0.2f)));
		objects.add(factory.makeGameObject("Orange", 0.15f+random.nextFloat()*(0.2f)));
		objects.add(factory.makeGameObject("FatalBomb", 0.15f+random.nextFloat()*(0.2f)));
		objects.add(factory.makeGameObject("DangerBomb", 0.15f+random.nextFloat()*(0.2f)));
	}
}
