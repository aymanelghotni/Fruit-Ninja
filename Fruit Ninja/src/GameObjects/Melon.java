package GameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.transition.Transition;
import org.newdawn.slick.tests.TransitionTest;

public class Melon extends GameObject {
	public Melon(int speed,int maxHeight,float xPos,float factor) {
		this.type="Melon";
		this.random=new Random();
		xDirection=random.nextBoolean();
		this.isMovedOffScreen=false;
		this.factor=factor;
		player=player.getInstance();
		this.isSliced=false;
		this.speed=speed;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.radius=50;
		this.yPos=800;
		
	}
	
	public void move()
	{
	
		if(yPos>maxHeight && !hasReachedMaximumHeight)
		{
			yPos-=speed*Statics.speedFactor;
			if(xDirection)
				xPos+=factor*speed*Statics.speedFactor;
			else
				xPos-=factor*speed*Statics.speedFactor;
			
		}
		if(yPos<=maxHeight)
		{
			hasReachedMaximumHeight=true;
		}
			
		if(hasReachedMaximumHeight && yPos<800 )
		{
			yPos+=speed*Statics.speedFactor;
			if(xDirection)
				xPos+=factor*speed*Statics.speedFactor;
			else
				xPos-=factor*speed*Statics.speedFactor;
			
		}
		if(yPos>=800)
		{
			if(!isSliced)
			{
				player.setLives(player.getLives()-1);
			}
			isMovedOffScreen=true;
		}
			
		
	}
}
 