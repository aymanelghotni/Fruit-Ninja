package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState{
	
	Image background;
	Input input;
	Image rookie;
	Image amateur;
	Image master;
	Image arcade;
	int xpos;
	int ypos;
	Sound music;
	String mouse="No input";
	Image logo;
	float y1;
	float y2;
	float y3;
	int flagA=0;
	int flagR=0;
	int flagM=0;
	int flagAR;
	float y4;
	public MainMenu(int id) {
		
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		input=gc.getInput();
		logo=new Image("data/logo.png");
		music=new Sound("data/music.wav");
		music.loop();
		y1=800-450;
		y2=800-450;
		y3=800-450;
		y4=800-200;
		flagA=0;
		flagR=0;
		flagM=0;
		flagAR=0;
		background=new Image("data/background.jpg");
		rookie=new Image("data/rookie.png");
		arcade=new Image("data/arcade.png");
		amateur=new Image("data/amateur.png");
		master=new Image("data/master.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,1200,800);
		
		rookie.draw(70,y1,0.15f);
		amateur.draw(470,y2,0.15f);
		master.draw(870,y3,0.15f);
		arcade.draw(470,y4,0.4f);
		logo.draw(200,0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
		xpos=Mouse.getX();
		ypos=800-Mouse.getY();
		mouse=xpos+","+ypos;
		if(xpos>80 && ypos>370 &&xpos<360 && ypos<550 && input.isMousePressed(0))
		{
			Game.difficulty=0;
			sbg.getState(Game.play).init(gc, sbg);
			flagR=1;

		}
		if(flagR==1)
		{
			y2+=delta;
			y3+=delta;
			y4+=delta;
			if(y2 >=800 && y3>=800 && y4>=800)
			{
				music.stop();
				sbg.enterState(Game.play,new FadeOutTransition(), new FadeInTransition());
			}
		}
			
		if(xpos>475 && ypos> 370 && ypos<550 && xpos<760 && input.isMousePressed(0))
		{
			Game.difficulty=1;
			sbg.getState(Game.play).init(gc, sbg);
			flagA=1;
			
		}
		if(flagA==1)
		{
			y1+=delta;
			y3+=delta;
			y4+=delta;
			if(y1 >=800 && y3>=800 && y4>=800)
			{
				music.stop();
				sbg.enterState(Game.play,new FadeOutTransition(), new FadeInTransition());
			}
		}
		
		if(xpos>875 && ypos> 370 && ypos<550 && xpos<1170 && input.isMousePressed(0))
		{
			Game.difficulty=2;
			flagM=1;
			sbg.getState(Game.play).init(gc, sbg);
			
		}
		
		if(flagM==1)
		{
			y2+=delta;
			y1+=delta;
			y4+=delta;
			if(y2 >=800 && y1>=800 && y4>=800)
			{
				music.stop();
				sbg.enterState(Game.play, new FadeOutTransition(), new FadeInTransition());
			}
		}
		
		if(xpos>475 && ypos> 620 && ypos<800 && xpos<760 && input.isMousePressed(0))
		{
			Game.difficulty=3;
			sbg.getState(Game.play).init(gc, sbg);
			flagAR=1;

		}
		if(flagAR==1)
		{
			y2+=delta;
			y3+=delta;
			y1+=delta;
			if(y2 >=800 && y3>=800 && y1>=800)
			{
				music.stop();
				sbg.enterState(Game.play,new FadeOutTransition(), new FadeInTransition());
			}
		}
			
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
