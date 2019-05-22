package GUI;

import java.io.IOException;
import java.util.Timer;

import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;
import org.newdawn.slick.util.BufferedImageUtil;

import Control.Command;
import Control.GameController;
import Control.LoadGame;
import Control.Player;
import Control.SaveGame;
import GameObjects.Apple;
import GameObjects.DangerBomb;
import GameObjects.DragonFruit;
import GameObjects.FatalBomb;
import GameObjects.GameObject;
import GameObjects.GameObjectFactory;
import GameObjects.Mango;
import GameObjects.Melon;
import GameObjects.Orange;
import GameObjects.SpecialFruit;
import GameObjects.Statics;


public class Play extends BasicGameState{

	Image background;
	Image object5;
	Image livesLabel;
	Image object4;
	Image object5Sliced;
	Image object4Sliced;
	Circle oval1;
	Circle oval2;
	Circle oval3;
	Circle oval4;
	Circle oval5;
	
	Command load;
	Command save;
	
	String score="NO input";
	
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
	Image roman;
	Image mango;
	Image dragon;
	
	Image applesliced;
	Image melonsliced;
	Image orangesliced;
	Image dangerexplosion;
	Image fatalexplosion;
	Image romansliced;
	Image dragonsliced;
	Image mangosliced;
	Image backgroundIce;
	
	Image gameover;
	
	GameObject obj1;
	GameObject obj2;
	GameObject obj3;
	GameObject obj4;
	GameObject obj5;
	GameController game;
	int flag1=0;
	
	int time;
	int timeSec;
	
	Sound slice;
	Sound fuse;
	Sound thro;
	Sound bomb1;
	Sound bomb2;
	Sound fatalalert;
	Sound special;
	
	Input input;
	public Play(int id) {
		// TODO Auto-generated constructor stub
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background=new Image("data/background.jpg");
		backgroundIce=new Image("data/backgroundicy.png");
		livesLabel=new Image("data/lives.png");
		gameover=new Image("data/gameover.png");
		
		
		game=new GameController(Game.difficulty);
		game.getPlayer().setScore(0);
		game.getPlayer().setLives(3);
		
		load=new LoadGame(game);
		save=new SaveGame(game);
		
		slice=new Sound("data/slice.wav");
		fuse=new Sound("data/fuse.wav");
		thro=new Sound("data/throw.wav");
		bomb1=new Sound("data/dangerbomb.wav");
		bomb2=new Sound("data/fatalbomb.wav");
		fatalalert=new Sound("data/fatalalert.wav");
		special=new Sound("data/specialsound.wav");
		
		game.randomizeGameObjects();
		obj1=game.getObjects().get(0);
		obj2=game.getObjects().get(1);
		obj3=game.getObjects().get(2);
		if(Game.difficulty>0)
		{
			obj4=game.getObjects().get(3);
			if(Game.difficulty>1)
				obj5=game.getObjects().get(4);
			
		}
	
		
		
		oval1=new Circle(obj1.getX(),obj1.getY(),obj1.getRadius());
		oval2=new Circle(obj2.getX(),obj2.getY(),obj2.getRadius());
		oval3=new Circle(obj3.getX(),obj3.getY(),obj3.getRadius());
		if(Game.difficulty>0)
		{
			oval4=new Circle(obj4.getX(),obj4.getY(),obj4.getRadius());
			if(Game.difficulty>1)
			{
				
				oval5=new Circle(obj5.getX(),obj5.getY(),obj5.getRadius());
		
			}
			
		}
		

		if(!Statics.arcade)
		{
			time=61;
			
			timeSec=0;
		}
		else
		{
			time=61;
			
			timeSec=60;
		}
		
		apple=new Image("data/apple.png");
		fatalbomb=new Image("data/bomb2.png");
		dangerbomb=new Image("data/bomb1.png");
		orange=new Image("data/orange.png");
		melon=new Image("data/melon.png");
		roman=new Image("data/roman.png");
		mango=new Image("data/mango.png");
		dragon=new Image("data/dragonfruit.png");
		gc.setMouseCursor(new Image("data/kunai.png"), 0, 0);
		
		applesliced=new Image("data/applesliced.png");
		fatalexplosion=new Image("data/explosion2.png");
		dangerexplosion=new Image("data/explosion.png");
		orangesliced=new Image("data/orangesliced.png");
		melonsliced=new Image("data/melonsliced.png");
		romansliced=new Image("data/romansliced.png");
		mangosliced=new Image("data/mangosliced.png");
		dragonsliced=new Image("data/dragonfruitsliced.png");
		
		if(obj1 instanceof Melon)
		{
			object1=melon;
			object1Sliced=melonsliced;
			thro.play();
		}
		
		if(obj1 instanceof Mango)
		{
			object1=mango;
			object1Sliced=mangosliced;
			special.play();
		}
		
		if(obj1 instanceof DragonFruit)
		{
			object1=dragon;
			object1Sliced=dragonsliced;
			special.play();
		}
		
		if(obj1 instanceof SpecialFruit)
		{
			object1=roman;
			object1Sliced=romansliced;
			special.play();
		}
			
		if(obj1 instanceof Apple)
		{
			object1=apple;
			object1Sliced=applesliced;
			thro.play();
		}
			
		if(obj1 instanceof Orange)
		{
			object1=orange;
			object1Sliced=orangesliced;
			thro.play();
		}
			
		if(obj1 instanceof DangerBomb)
		{
			object1=dangerbomb;
			object1Sliced=dangerexplosion;
			thro.play();
		}
			
		if(obj1 instanceof FatalBomb)
		{
			object1=fatalbomb;
			object1Sliced=fatalexplosion;
			thro.play();
		}
		
		
		if(obj2 instanceof Mango)
		{
			object2=mango;
			object2Sliced=mangosliced;
			special.play();
		}
		
		if(obj2 instanceof DragonFruit)
		{
			object2=dragon;
			object2Sliced=dragonsliced;
			special.play();
		}
		
		if(obj2 instanceof SpecialFruit)
		{
			object2=roman;
			object2Sliced=romansliced;
			special.play();
		}
		
		if(obj2 instanceof Melon)
		{
			object2=melon;
			object2Sliced=melonsliced;
			thro.play();
		}
			
		if(obj2 instanceof Apple)
		{
			object2=apple;
			object2Sliced=applesliced;
			thro.play();
		}
			
		if(obj2 instanceof Orange)
		{
			object2=orange;
			object2Sliced=orangesliced;
			thro.play();
		}
			
		if(obj2 instanceof DangerBomb)
		{
			object2=dangerbomb;
			object2Sliced=dangerexplosion;
			thro.play();
		}
			
		if(obj2 instanceof FatalBomb)
		{
			object2=fatalbomb;
			object2Sliced=fatalexplosion;
			thro.play();
		}
		
		if(obj3 instanceof Mango)
		{
			object3=mango;
			object3Sliced=mangosliced;
			special.play();
		}
		
		if(obj3 instanceof DragonFruit)
		{
			object3=dragon;
			object3Sliced=dragonsliced;
			special.play();
		}
		
		if(obj3 instanceof SpecialFruit)
		{
			object3=roman;
			object3Sliced=romansliced;
			special.play();
		}
		
		if(obj3 instanceof Melon)
		{
			object3=melon;
			object3Sliced=melonsliced;
			thro.play();
		}
			
		if(obj3 instanceof Apple)
		{
			object3=apple;
			object3Sliced=applesliced;
			thro.play();
		}
			
		if(obj3 instanceof Orange)
		{
			object3=orange;
			object3Sliced=orangesliced;
			thro.play();
		}
			
		if(obj3 instanceof DangerBomb)
		{
			object3=dangerbomb;
			object3Sliced=dangerexplosion;
			thro.play();
		}
			
		if(obj3 instanceof FatalBomb)
		{
			object3=fatalbomb;
			object3Sliced=fatalexplosion;
			thro.play();
		}
		
		if(Game.difficulty>0)
		{
			
			if(obj4 instanceof Mango)
			{
				object4=mango;
				object4Sliced=mangosliced;
				special.play();
			}
			
			if(obj4 instanceof DragonFruit)
			{
				object4=dragon;
				object4Sliced=dragonsliced;
				special.play();
			}
			
			if(obj4 instanceof SpecialFruit)
			{
				object4=roman;
				object4Sliced=romansliced;
				special.play();
			}
			
			if(obj4 instanceof Melon)
			{
				object4=melon;
				object4Sliced=melonsliced;
				thro.play();
			}
				
			if(obj4 instanceof Apple)
			{
				object4=apple;
				object4Sliced=applesliced;
				thro.play();
			}
				
			if(obj4 instanceof Orange)
			{
				object4=orange;
				object4Sliced=orangesliced;
				thro.play();
			}
				
			if(obj4 instanceof DangerBomb)
			{
				object4=dangerbomb;
				object4Sliced=dangerexplosion;
				thro.play();
			}
				
			if(obj4 instanceof FatalBomb)
			{
				object4=fatalbomb;
				object4Sliced=fatalexplosion;
				thro.play();
			}
			
			if(Game.difficulty>1)
			{
				
				if(obj5 instanceof Mango)
				{
					object5=mango;
					object5Sliced=mangosliced;
					special.play();
				}
				
				if(obj5 instanceof DragonFruit)
				{
					object5=dragon;
					object5Sliced=dragonsliced;
					special.play();
				}
				
				if(obj5 instanceof SpecialFruit)
				{
					object5=roman;
					object5Sliced=romansliced;
					special.play();
				}
				
				if(obj5 instanceof Melon)
				{
					object5=melon;
					object5Sliced=melonsliced;
					thro.play();
				}
					
				if(obj5 instanceof Apple)
				{
					object5=apple;
					object5Sliced=applesliced;
					thro.play();
				}
					
				if(obj5 instanceof Orange)
				{
					object5=orange;
					object5Sliced=orangesliced;
					thro.play();
				}
					
				if(obj5 instanceof DangerBomb)
				{
					object5=dangerbomb;
					object5Sliced=dangerexplosion;
					thro.play();
				}
					
				if(obj5 instanceof FatalBomb)
				{
					object5=fatalbomb;
					object5Sliced=fatalexplosion;
					thro.play();
				}
				
				
		}
			
			
		}
		
		
		
		load.execute();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(Statics.flagIce==0)
		{
			background.draw(0,0,1200,800);
		}
		else
			backgroundIce.draw(0,0,1200,800);
		if(!Statics.arcade)
		{
			livesLabel.draw(0, 0,255,150);
			if(game.getPlayer().getLives()==3)
			{
				melon.draw(30, 30, 60, 60);
				melon.draw(95, 30, 60, 60);
				melon.draw(160, 30, 60, 60);
			}
			if(game.getPlayer().getLives()==2)
			{
				melonsliced.draw(30, 30, 60, 60);
				melon.draw(95, 30, 60, 60);
				melon.draw(160, 30, 60, 60);
			}
			
			if(game.getPlayer().getLives()==1)
			{
				melonsliced.draw(30, 30, 60, 60);
				melonsliced.draw(95, 30, 60, 60);
				melon.draw(160, 30, 60, 60);
			}
			
			if(game.getPlayer().getLives()==0)
			{
				
				melonsliced.draw(30, 30, 60, 60);
				melonsliced.draw(95, 30, 60, 60);
				melonsliced.draw(160, 30, 60, 60);
				
			}
		}
		
		
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

		
		if(Game.difficulty>0)
		{
			if(!obj4.isSliced())
			{
				object4.draw(obj4.getX(), obj4.getY(), obj4.getRadius()*2, obj4.getRadius()*2);
				
			}
			else
				object4Sliced.draw(obj4.getX(), obj4.getY(), obj4.getRadius()*2, obj4.getRadius()*2);
			if(Game.difficulty>1)
			{
				if(!obj5.isSliced())
				{
					object5.draw(obj5.getX(), obj5.getY(), obj5.getRadius()*2, obj5.getRadius()*2);
					
				}
				else
					object5Sliced.draw(obj5.getX(), obj5.getY(), obj5.getRadius()*2, obj5.getRadius()*2);
				
			}
		}
		


		
		
		
		g.scale(2f, 2f);
		g.drawString("Score: "+String.valueOf(game.getPlayer().getScore())+" Best:"+game.getPlayer().getHighScore(),250, 10);
		g.drawString(String.valueOf(timeSec),550, 10);
		if(Game.difficulty>0)
		{
			oval4.setX(obj4.getX());
			oval4.setY(obj4.getY());
			oval4.setRadius(obj4.getRadius());
			if(Game.difficulty>1)
			{
				oval5.setY(obj5.getY());
				oval5.setX(obj5.getX());
				oval5.setRadius(obj5.getRadius());
			}
		}
		
		
		oval3.setX(obj3.getX());
		oval3.setY(obj3.getY());
		oval3.setRadius(obj3.getRadius());
		oval2.setX(obj2.getX());
		oval2.setY(obj2.getY());
		oval2.setRadius(obj2.getRadius());
		oval1.setX(obj1.getX());
		oval1.setY(obj1.getY());
		oval1.setRadius(obj1.getRadius());
		
		if(game.getPlayer().getLives()==0 && !Statics.arcade)
			gameover.draw(150,120,0.75f);
		if(timeSec<1 && Statics.arcade)
			gameover.draw(150,120,0.75f);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		input=gc.getInput();
		if(game.getPlayer().getLives()==0 && !Statics.arcade)
		{
			
			if(game.getPlayer().getScore()>game.getPlayer().getHighScore())
				game.getPlayer().setHighScore(game.getPlayer().getScore());
			if(input.isMousePressed(0))
			{
				sbg.getState(Game.mainmenu).init(gc, sbg);
				save.execute();
				sbg.enterState(Game.mainmenu,new FadeOutTransition(),new FadeInTransition());
			}
				
		}
		if(Statics.arcade && timeSec<1)
		{
			
			if(game.getPlayer().getScore()>game.getPlayer().getHighScore())
				game.getPlayer().setHighScore(game.getPlayer().getScore());
			if(input.isMousePressed(0))
			{
				sbg.getState(Game.mainmenu).init(gc, sbg);
				sbg.enterState(Game.mainmenu,new FadeOutTransition(),new FadeInTransition());
			}
				
		}
		
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		if(game.getPlayer().getLives() >0 || (Statics.arcade && timeSec>0))
		{
			
			time++;
			
			if(!Statics.arcade)
			{
				
				if(time%60==0)
				{
					
					timeSec++;
				}
			}
			if(Statics.arcade)
			{
				if(time%60==0)
				{
					
					timeSec--;
				}
			}
			
			
			
			if(!obj1.ifMovedOffScreen())
				obj1.move();
			else
			{
				obj1=game.createObject();
				thro.play();
				
				if(obj1 instanceof Mango)
				{
					object1=mango;
					object1Sliced=mangosliced;
					special.play();
				}
				
				if(obj1 instanceof DragonFruit)
				{
					object1=dragon;
					object1Sliced=dragonsliced;
					special.play();
				}
				
				if(obj1 instanceof Melon)
				{
					object1=melon;
					object1Sliced=melonsliced;
				}
				
				if(obj1 instanceof SpecialFruit)
				{
					object1=roman;
					object1Sliced=romansliced;
					special.play();
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
					fuse.play();
				}
					
				if(obj1 instanceof FatalBomb)
				{
					object1=fatalbomb;
					object1Sliced=fatalexplosion;
					fatalalert.play();
					
				}
					
				
				
			}
				
			if(!obj2.ifMovedOffScreen())
				obj2.move();
			else
			{
				obj2=game.createObject();
				thro.play();
				
				if(obj2 instanceof Mango)
				{
					object2=mango;
					object2Sliced=mangosliced;
					special.play();
				}
				
				if(obj2 instanceof DragonFruit)
				{
					object2=dragon;
					object2Sliced=dragonsliced;
					special.play();
				}
				
				if(obj2 instanceof Melon)
				{
					object2=melon;
					object2Sliced=melonsliced;
				}
				
				if(obj2 instanceof SpecialFruit)
				{
					object2=roman;
					object2Sliced=romansliced;
					special.play();
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
					fuse.play();
				}
					
				if(obj2 instanceof FatalBomb)
				{
					object2=fatalbomb;
					object2Sliced=fatalexplosion;
					fatalalert.play();
				}
			}
				
			if(!obj3.ifMovedOffScreen())
				obj3.move();
			else
			{
				obj3=game.createObject();
				thro.play();
				
				if(obj3 instanceof Mango)
				{
					object3=mango;
					object3Sliced=mangosliced;
					special.play();
				}
				
				if(obj3 instanceof DragonFruit)
				{
					object3=dragon;
					object3Sliced=dragonsliced;
					special.play();
				}
				
				if(obj3 instanceof Melon)
				{
					object3=melon;
					object3Sliced=melonsliced;
				}
				
				if(obj3 instanceof SpecialFruit)
				{
					object3=roman;
					object3Sliced=romansliced;
					special.play();
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
					fuse.play();
				}
					
				if(obj3 instanceof FatalBomb)
				{
					object3=fatalbomb;
					object3Sliced=fatalexplosion;
					fatalalert.play();
				}
			}
			
			
			if(Game.difficulty>0)
			{
				if(!obj4.ifMovedOffScreen())
					obj4.move();
				else
				{
					obj4=game.createObject();
					thro.play();
					
					if(obj4 instanceof Mango)
					{
						object4=mango;
						object4Sliced=mangosliced;
						special.play();
					}
					
					if(obj4 instanceof DragonFruit)
					{
						object4=dragon;
						object4Sliced=dragonsliced;
						special.play();
					}
					
					if(obj4 instanceof Melon)
					{
						object4=melon;
						object4Sliced=melonsliced;
					}
					
					if(obj4 instanceof SpecialFruit)
					{
						object4=roman;
						object4Sliced=romansliced;
						special.play();
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
						fuse.play();
					}
						
					if(obj4 instanceof FatalBomb)
					{
						object4=fatalbomb;
						object4Sliced=fatalexplosion;
						fatalalert.play();
					}
				}
				if(Game.difficulty==2)
				{
					if(!obj5.ifMovedOffScreen())
						obj5.move();
					else
					{
						obj5=game.createObject();
						thro.play();
						if(obj5 instanceof Mango)
						{
							object5=mango;
							object5Sliced=mangosliced;
							special.play();
						}
						
						if(obj5 instanceof DragonFruit)
						{
							object5=dragon;
							object5Sliced=dragonsliced;
							special.play();
						}
						
						
						if(obj5 instanceof Melon)
						{
							object5=melon;
							object5Sliced=melonsliced;
						}
						
						if(obj5 instanceof SpecialFruit)
						{
							object5=roman;
							object5Sliced=romansliced;
							special.play();
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
							fuse.play();

						}
							
						if(obj5 instanceof FatalBomb)
						{
							object5=fatalbomb;
							object5Sliced=fatalexplosion;
							fatalalert.play();
						}
					}
				}
			}
				
			
				
			
				
			if(xpos>oval1.getMinX() && xpos<oval1.getMaxX() && 800-ypos<oval1.getMaxY() && 800-ypos>oval1.getMinY() && !obj1.isSliced())
			{
				obj1.slice();obj1.setxDirection(!obj1.getXDirection());
				slice.play();
				if(obj1 instanceof DangerBomb)
				{
					bomb1.play();
				}
				if(obj1 instanceof FatalBomb )
				{
					bomb2.play();
				}
				
			
			}
				
			
			if(xpos>oval2.getMinX() && xpos<oval2.getMaxX() && 800-ypos<oval2.getMaxY() && 800-ypos>oval2.getMinY() && !obj2.isSliced())
			{
				obj2.slice();obj2.setxDirection(!obj2.getXDirection());
				slice.play();
				if(obj2 instanceof DangerBomb)
				{
					bomb1.play();
				}
				
				if(obj2 instanceof FatalBomb )
				{
					bomb2.play();
				}
			}
				
			if(xpos>oval3.getMinX() && xpos<oval3.getMaxX() && 800-ypos<oval3.getMaxY() && 800-ypos>oval3.getMinY() && !obj3.isSliced())
			{
				obj3.slice();obj3.setxDirection(!obj3.getXDirection());
				slice.play();
				if(obj3 instanceof DangerBomb)
				{
					bomb1.play();
				}
				if(obj3 instanceof FatalBomb )
				{
					bomb2.play();
				}
			
			}
			
			if(Game.difficulty>0)
			{
				if(xpos>oval4.getMinX() && xpos<oval4.getMaxX() && 800-ypos<oval4.getMaxY() && 800-ypos>oval4.getMinY()&& !obj4.isSliced())
				{
					obj4.slice();obj4.setxDirection(!obj4.getXDirection());
					slice.play();
					if(obj4 instanceof DangerBomb )
					{
						bomb1.play();
					}
					if(obj4 instanceof FatalBomb )
					{
						bomb2.play();
					}
					
				}
				
				if(Game.difficulty>1)
				{
					if(xpos>oval5.getMinX() && xpos<oval5.getMaxX() && 800-ypos<oval5.getMaxY() && 800-ypos>oval5.getMinY() && !obj5.isSliced())
					{
						obj5.slice();obj5.setxDirection(!obj5.getXDirection());
						slice.play();
						if(obj5 instanceof DangerBomb)
						{
							bomb1.play();
						}
						if(obj5 instanceof FatalBomb )
						{
							bomb2.play();
						}
						
					}
				}
			}
				
			
				
			
			
			
			//collisions 1
			
			if(Math.hypot(oval1.getCenterX()-oval2.getCenterX(), oval1.getCenterY()-oval2.getCenterY()) < oval1.getRadius()+oval2.getRadius() && obj2.getXDirection() != obj1.getXDirection())
			{
				obj1.setxDirection(!obj1.getXDirection());
				obj2.setxDirection(!obj2.getXDirection());
			}
			
			if(Math.hypot(oval1.getCenterX()-oval3.getCenterX(), oval1.getCenterY()-oval3.getCenterY()) < oval1.getRadius()+oval3.getRadius()  && obj3.getXDirection() != obj1.getXDirection())
			{
				obj1.setxDirection(!obj1.getXDirection());
				obj3.setxDirection(!obj3.getXDirection());
			}
			if(Game.difficulty>0)
			{
				if(Math.hypot(oval1.getCenterX()-oval4.getCenterX(), oval1.getCenterY()-oval4.getCenterY()) < oval1.getRadius()+oval4.getRadius() && obj4.getXDirection() != obj1.getXDirection())
				{
					obj1.setxDirection(!obj1.getXDirection());
					obj4.setxDirection(!obj4.getXDirection());
				}
				if(Math.hypot(oval2.getCenterX()-oval2.getCenterX(), oval4.getCenterY()-oval2.getCenterY()) < oval2.getRadius()+oval4.getRadius()  && obj4.getXDirection() != obj2.getXDirection())
				{
					obj4.setxDirection(!obj4.getXDirection());
					obj2.setxDirection(!obj2.getXDirection());
				}
				
				if(Math.hypot(oval3.getCenterX()-oval4.getCenterX(), oval3.getCenterY()-oval4.getCenterY()) < oval3.getRadius()+oval4.getRadius()  && obj4.getXDirection() != obj3.getXDirection())
				{
					obj3.setxDirection(!obj3.getXDirection());
					obj4.setxDirection(!obj4.getXDirection());
				}
				
				
				if(Game.difficulty>1)
				{
					if(Math.hypot(oval4.getCenterX()-oval5.getCenterX(), oval4.getCenterY()-oval5.getCenterY()) < oval4.getRadius()+oval5.getRadius() && obj4.getXDirection() != obj5.getXDirection())
					{
						obj4.setxDirection(!obj4.getXDirection());
						obj5.setxDirection(!obj5.getXDirection());
					}
					
					if(Math.hypot(oval1.getCenterX()-oval5.getCenterX(), oval5.getCenterY()-oval5.getCenterY()) < oval1.getRadius()+oval5.getRadius() && obj1.getXDirection() != obj5.getXDirection())
					{
						obj1.setxDirection(!obj1.getXDirection());
						obj5.setxDirection(!obj5.getXDirection());
					}
					
					if(Math.hypot(oval5.getCenterX()-oval2.getCenterX(), oval5.getCenterY()-oval2.getCenterY()) < oval5.getRadius()+oval2.getRadius()  && obj2.getXDirection() != obj5.getXDirection())
					{
						obj5.setxDirection(!obj5.getXDirection());
						obj2.setxDirection(!obj2.getXDirection());
					}
					
					if(Math.hypot(oval3.getCenterX()-oval5.getCenterX(), oval3.getCenterY()-oval5.getCenterY()) < oval3.getRadius()+oval5.getRadius() && obj5.getXDirection() != obj3.getXDirection())
					{
						obj3.setxDirection(!obj3.getXDirection());
						obj5.setxDirection(!obj5.getXDirection());
					}
					
					
				}
			}
			
			
			
			
			
			//collisions 2
			
			
			
			
			
			if(Math.hypot(oval2.getCenterX()-oval3.getCenterX(), oval2.getCenterY()-oval3.getCenterY()) < oval2.getRadius()+oval3.getRadius()  && obj2.getXDirection() != obj3.getXDirection())
			{
				obj3.setxDirection(!obj3.getXDirection());
				obj2.setxDirection(!obj2.getXDirection());
			}
			
			//collisions 3
			
			
			
			//collisions 4
			
			
			
			//collisions 5
			if(oval1.getMinX()<=0 || oval1.getMaxX()>=1200)
				obj1.setxDirection(!obj1.getXDirection());
			
			if(oval2.getMinX()<=0 || oval2.getMaxX()>=1200)
				obj2.setxDirection(!obj2.getXDirection());
			
			if(oval3.getMinX()<=0 || oval3.getMaxX()>=1200)
				obj3.setxDirection(!obj3.getXDirection());
			
			if(Game.difficulty>0)
			{
				
				if(oval4.getMinX()<=0 || oval4.getMaxX()>=1200)
					obj4.setxDirection(!obj4.getXDirection());
				if(Game.difficulty>1)
				{
					if(oval5.getMinX()<=0 || oval5.getMaxX()>=1200)
						obj5.setxDirection(!obj5.getXDirection());
				}
			}
					
			
		}
	
	}

	@Override
	public int getID() {
		
		return 2;
	}

}
