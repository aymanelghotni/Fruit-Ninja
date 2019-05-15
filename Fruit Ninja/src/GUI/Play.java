package GUI;

import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.BufferedImageUtil;

import Control.GameController;
import GameObjects.Apple;
import GameObjects.DangerBomb;
import GameObjects.FatalBomb;
import GameObjects.GameObject;
import GameObjects.GameObjectFactory;
import GameObjects.Melon;
import GameObjects.Orange;


public class Play extends BasicGameState{

	Image background;
	Image object5;
	Image object4;
	Image object5Sliced;
	Image object4Sliced;
	Circle oval1;
	Circle oval2;
	Circle oval3;
	Circle oval4;
	Circle oval5;
	Image object3;
	Image object2;
	Image object1;
	Image object3Sliced;
	Image object2Sliced;
	Image object1Sliced;
	
	Image apple;
	Image melon;
	Image orange;
	Image dangerbomb;
	Image fatalbomb;
	
	Image applesliced;
	Image melonsliced;
	Image orangesliced;
	Image dangerexplosion;
	Image fatalexplosion;
	
	GameObject obj1;
	GameObject obj2;
	GameObject obj3;
	GameObject obj4;
	GameObject obj5;
	GameController game;
	int flag1=0;
	
	
	public Play(int id) {
		// TODO Auto-generated constructor stub
	}
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background=new Image("data/background.jpg");
		game=new GameController(2);
		game.randomizeGameObjects();
		obj1=game.getObjects().get(0);
		obj2=game.getObjects().get(1);
		obj3=game.getObjects().get(2);
		obj4=game.getObjects().get(3);
		obj5=game.getObjects().get(4);
		
		oval1=new Circle(obj1.getX(),obj1.getY(),obj1.getRadius());
		oval2=new Circle(obj2.getX(),obj2.getY(),obj2.getRadius());
		oval3=new Circle(obj3.getX(),obj3.getY(),obj3.getRadius());
		oval4=new Circle(obj4.getX(),obj4.getY(),obj4.getRadius());
		oval5=new Circle(obj5.getX(),obj5.getY(),obj5.getRadius());


		
		apple=new Image("data/apple.png");
		fatalbomb=new Image("data/bomb2.png");
		dangerbomb=new Image("data/bomb1.png");
		orange=new Image("data/orange.png");
		melon=new Image("data/melon.png");
		
		applesliced=new Image("data/applesliced.png");
		fatalexplosion=new Image("data/explosion2.png");
		dangerexplosion=new Image("data/explosion.png");
		orangesliced=new Image("data/orangesliced.png");
		melonsliced=new Image("data/melonsliced.png");
		
		if(obj1 instanceof Melon)
		{
			object1=melon;
			object1Sliced=melonsliced;
		}
			
		if(obj1 instanceof Apple)
		{
			object1=apple;
			object1Sliced=applesliced;
		}
			
		if(obj1 instanceof Orange)
		{
			object1=orange;
			object1Sliced=orangesliced;
		}
			
		if(obj1 instanceof DangerBomb)
		{
			object1=dangerbomb;
			object1Sliced=dangerexplosion;
		}
			
		if(obj1 instanceof FatalBomb)
		{
			object1=fatalbomb;
			object1Sliced=fatalexplosion;
		}
		
		if(obj2 instanceof Melon)
		{
			object2=melon;
			object2Sliced=melonsliced;
		}
			
		if(obj2 instanceof Apple)
		{
			object2=apple;
			object2Sliced=applesliced;
		}
			
		if(obj2 instanceof Orange)
		{
			object2=orange;
			object2Sliced=orangesliced;
		}
			
		if(obj2 instanceof DangerBomb)
		{
			object2=dangerbomb;
			object2Sliced=dangerexplosion;
		}
			
		if(obj2 instanceof FatalBomb)
		{
			object2=fatalbomb;
			object2Sliced=fatalexplosion;
		}
		
		if(obj3 instanceof Melon)
		{
			object3=melon;
			object3Sliced=melonsliced;
		}
			
		if(obj3 instanceof Apple)
		{
			object3=apple;
			object3Sliced=applesliced;
		}
			
		if(obj3 instanceof Orange)
		{
			object3=orange;
			object3Sliced=orangesliced;
		}
			
		if(obj3 instanceof DangerBomb)
		{
			object3=dangerbomb;
			object3Sliced=dangerexplosion;
		}
			
		if(obj3 instanceof FatalBomb)
		{
			object3=fatalbomb;
			object3Sliced=fatalexplosion;
		}
		
		if(obj4 instanceof Melon)
		{
			object4=melon;
			object4Sliced=melonsliced;
		}
			
		if(obj4 instanceof Apple)
		{
			object4=apple;
			object4Sliced=applesliced;
		}
			
		if(obj4 instanceof Orange)
		{
			object4=orange;
			object4Sliced=orangesliced;
		}
			
		if(obj4 instanceof DangerBomb)
		{
			object4=dangerbomb;
			object4Sliced=dangerexplosion;
		}
			
		if(obj4 instanceof FatalBomb)
		{
			object4=fatalbomb;
			object4Sliced=fatalexplosion;
		}
		
		if(obj5 instanceof Melon)
		{
			object5=melon;
			object5Sliced=melonsliced;
		}
			
		if(obj5 instanceof Apple)
		{
			object5=apple;
			object5Sliced=applesliced;
		}
			
		if(obj5 instanceof Orange)
		{
			object5=orange;
			object5Sliced=orangesliced;
		}
			
		if(obj5 instanceof DangerBomb)
		{
			object5=dangerbomb;
			object5Sliced=dangerexplosion;
		}
			
		if(obj5 instanceof FatalBomb)
		{
			object5=fatalbomb;
			object5Sliced=fatalexplosion;
		}
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,1200,800);
		if(!obj1.isSliced())
		{
			object1.draw(obj1.getX(), obj1.getY(), obj1.getRadius()*2, obj1.getRadius()*2);
			
		}
		else
			object1Sliced.draw(obj1.getX(), obj1.getY(), obj1.getRadius()*2, obj1.getRadius()*2);
		
		
		if(!obj2.isSliced())
		{
			object2.draw(obj2.getX(), obj2.getY(), obj2.getRadius()*2, obj2.getRadius()*2);
			
		}
		else
			object2Sliced.draw(obj2.getX(), obj2.getY(), obj2.getRadius()*2, obj2.getRadius()*2);
		
		if(!obj3.isSliced())
		{
			object3.draw(obj3.getX(), obj3.getY(), obj3.getRadius()*2, obj3.getRadius()*2);
			
		}
		else
			object3Sliced.draw(obj3.getX(), obj3.getY(), obj3.getRadius()*2, obj3.getRadius()*2);

		

		if(!obj4.isSliced())
		{
			object4.draw(obj4.getX(), obj4.getY(), obj4.getRadius()*2, obj4.getRadius()*2);
			
		}
		else
			object4Sliced.draw(obj4.getX(), obj4.getY(), obj4.getRadius()*2, obj4.getRadius()*2);


		if(!obj5.isSliced())
		{
			object5.draw(obj5.getX(), obj5.getY(), obj5.getRadius()*2, obj5.getRadius()*2);
			
		}
		else
			object5Sliced.draw(obj5.getX(), obj5.getY(), obj5.getRadius()*2, obj5.getRadius()*2);
		
		oval5.setX(obj5.getX());
		oval5.setY(obj5.getY());
		oval5.setRadius(obj5.getRadius());
		oval4.setX(obj4.getX());
		oval4.setY(obj4.getY());
		oval4.setRadius(obj4.getRadius());
		oval3.setX(obj3.getX());
		oval3.setY(obj3.getY());
		oval3.setRadius(obj3.getRadius());
		oval2.setX(obj2.getX());
		oval2.setY(obj2.getY());
		oval2.setRadius(obj2.getRadius());
		oval1.setX(obj1.getX());
		oval1.setY(obj1.getY());
		oval1.setRadius(obj1.getRadius());
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		if(game.getPlayer().getLives()!=0)
		{
			if(!obj1.ifMovedOffScreen())
				obj1.move();
			else
			{
				obj1=game.createObject();
				if(obj1 instanceof Melon)
				{
					object1=melon;
					object1Sliced=melonsliced;
				}
					
				if(obj1 instanceof Apple)
				{
					object1=apple;
					object1Sliced=applesliced;
				}
					
				if(obj1 instanceof Orange)
				{
					object1=orange;
					object1Sliced=orangesliced;
				}
					
				if(obj1 instanceof DangerBomb)
				{
					object1=dangerbomb;
					object1Sliced=dangerexplosion;
				}
					
				if(obj1 instanceof FatalBomb)
				{
					object1=fatalbomb;
					object1Sliced=fatalexplosion;
				}
					
				
				
			}
				
			if(!obj2.ifMovedOffScreen())
				obj2.move();
			else
			{
				obj2=game.createObject();
				if(obj2 instanceof Melon)
				{
					object2=melon;
					object2Sliced=melonsliced;
				}
					
				if(obj2 instanceof Apple)
				{
					object2=apple;
					object2Sliced=applesliced;
				}
					
				if(obj2 instanceof Orange)
				{
					object2=orange;
					object2Sliced=orangesliced;
				}
					
				if(obj2 instanceof DangerBomb)
				{
					object2=dangerbomb;
					object2Sliced=dangerexplosion;
				}
					
				if(obj2 instanceof FatalBomb)
				{
					object2=fatalbomb;
					object2Sliced=fatalexplosion;
				}
			}
				
			if(!obj3.ifMovedOffScreen())
				obj3.move();
			else
			{
				obj3=game.createObject();
				if(obj3 instanceof Melon)
				{
					object3=melon;
					object3Sliced=melonsliced;
				}
					
				if(obj3 instanceof Apple)
				{
					object3=apple;
					object3Sliced=applesliced;
				}
					
				if(obj3 instanceof Orange)
				{
					object3=orange;
					object3Sliced=orangesliced;
				}
					
				if(obj3 instanceof DangerBomb)
				{
					object3=dangerbomb;
					object3Sliced=dangerexplosion;
				}
					
				if(obj3 instanceof FatalBomb)
				{
					object3=fatalbomb;
					object3Sliced=fatalexplosion;
				}
			}
				
			if(!obj4.ifMovedOffScreen())
				obj4.move();
			else
			{
				obj4=game.createObject();
				if(obj4 instanceof Melon)
				{
					object4=melon;
					object4Sliced=melonsliced;
				}
					
				if(obj4 instanceof Apple)
				{
					object4=apple;
					object4Sliced=applesliced;
				}
					
				if(obj4 instanceof Orange)
				{
					object4=orange;
					object4Sliced=orangesliced;
				}
					
				if(obj4 instanceof DangerBomb)
				{
					object4=dangerbomb;
					object4Sliced=dangerexplosion;
				}
					
				if(obj4 instanceof FatalBomb)
				{
					object4=fatalbomb;
					object4Sliced=fatalexplosion;
				}
			}
				
			if(!obj5.ifMovedOffScreen())
				obj5.move();
			else
			{
				obj5=game.createObject();
				if(obj5 instanceof Melon)
				{
					object5=melon;
					object5Sliced=melonsliced;
				}
					
				if(obj5 instanceof Apple)
				{
					object5=apple;
					object5Sliced=applesliced;
				}
					
				if(obj5 instanceof Orange)
				{
					object5=orange;
					object5Sliced=orangesliced;
				}
					
				if(obj5 instanceof DangerBomb)
				{
					object5=dangerbomb;
					object5Sliced=dangerexplosion;
				}
					
				if(obj5 instanceof FatalBomb)
				{
					object5=fatalbomb;
					object5Sliced=fatalexplosion;
				}
			}
				
			if(xpos>oval1.getMinX() && xpos<oval1.getMaxX() && 800-ypos<oval1.getMaxY() && 800-ypos>oval1.getMinY())
				obj1.slice();
			
			if(xpos>oval2.getMinX() && xpos<oval2.getMaxX() && 800-ypos<oval2.getMaxY() && 800-ypos>oval2.getMinY())
				obj2.slice();
			if(xpos>oval3.getMinX() && xpos<oval3.getMaxX() && 800-ypos<oval3.getMaxY() && 800-ypos>oval3.getMinY())
				obj3.slice();
			if(xpos>oval4.getMinX() && xpos<oval4.getMaxX() && 800-ypos<oval4.getMaxY() && 800-ypos>oval4.getMinY())
				obj4.slice();
			if(xpos>oval5.getMinX() && xpos<oval5.getMaxX() && 800-ypos<oval5.getMaxY() && 800-ypos>oval5.getMinY())
				obj5.slice();
		}
		
		
		
			
		
	
	}

	@Override
	public int getID() {
		
		return 2;
	}

}
