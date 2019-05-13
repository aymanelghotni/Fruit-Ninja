package GUI;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import GameObjects.GameObject;
import GameObjects.GameObjectFactory;


public class Play extends BasicGameState{

	Image background;
	Image melon;
	Image apple;
	Circle oval;
	Image orange;
	Image fatalBomb;
	Image dangerBomb;
	float shiftMelonY=800;
	float shiftMelonX=100;
	GameObject melonObj;
	GameObjectFactory factory;
	int flag1=0;
	
	
	public Play(int id) {
		// TODO Auto-generated constructor stub
	}
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background=new Image("data/background.jpg");
		melon=new Image("data/Watermelon.png");
		oval=new Circle(135, shiftMelonY, 35);
		factory=new GameObjectFactory();
		melonObj=factory.makeGameObject("melon", 0.2f, 500, 100);
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,1200,800);
		oval.setY(melonObj.getY());
		oval.setX(melonObj.getX());
		melon.draw(melonObj.getX(), melonObj.getY(), 70, 70);
		//g.draw(oval);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		melonObj.move();
			
		
	
	}

	@Override
	public int getID() {
		
		return 2;
	}

}
