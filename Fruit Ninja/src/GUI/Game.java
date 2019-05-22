package GUI;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{
	
	
	public static final String gamename="Fruit Ninja";
	public static final int mainmenu=0;
	public static final int play=2;
	public static final int levelmenu=1;
	public static int difficulty=0;
	
	
	public Game(String name) {
		super(name);
		this.addState(new MainMenu(mainmenu));
		this.addState(new Play(play));
		this.enterState(mainmenu);
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc=new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(1200,800, false);
			appgc.setVSync(true);
			appgc.start();
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
	}
	
}
