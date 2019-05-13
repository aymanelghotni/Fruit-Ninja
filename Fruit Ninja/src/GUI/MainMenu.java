package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{
	
	Image background;
	Input input;
	Image rookie;
	Image amateur;
	Image master;
	int xpos;
	int ypos;
	String mouse="No input";
	
	public MainMenu(int id) {
		
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		input=gc.getInput();
		background=new Image("data/background.jpg");
		rookie=new Image("data/rookie.png");
		amateur=new Image("data/amateur.png");
		master=new Image("data/master.png");	
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,1200,800);
		g.drawString(mouse, 50, 50);
		rookie.draw(70,800-550,0.15f);
		amateur.draw(470,800-550,0.15f);
		master.draw(870,800-550,0.15f);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
		xpos=Mouse.getX();
		ypos=Mouse.getY();
		mouse=xpos+","+ypos;
		
			
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
