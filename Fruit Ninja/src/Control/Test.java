package Control;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args)
	{
		GameController game= new GameController(0);
		game.randomizeGameObjects();
		Command save=new SaveGame(game);
		/*game.slice(game.objects.get(0));
		game.slice(game.objects.get(1));
		game.slice(game.objects.get(2));
		game.slice(game.objects.get(3));
		game.slice(game.objects.get(4));
		System.out.println(game.player.getScore()+" "+game.player.getLives());*/
		
		
		
		
	}
}
