package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{
	
	Image background;
	Image board;
	int xpos;
	int ypos;
	String mouse="No input";
	
	public MainMenu(int id) {
		
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background=new Image("data/background.jpg");
		board=new Image("data/board.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,1200,800);
		g.drawString(mouse, 50, 50);
		board.draw(70,800-550,0.4f);
		board.draw(470,800-550,0.4f);
		board.draw(870,800-550,0.4f);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	
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
