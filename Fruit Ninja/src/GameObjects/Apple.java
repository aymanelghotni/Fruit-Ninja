package GameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Apple extends GameObject {
	public Apple(int speed,int maxHeight,float xPos) {
		this.type="Apple";
		player=player.getInstance();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		this.radius=35;
		this.random=new Random();
		xDirection=random.nextBoolean();
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
		try {
			images=new BufferedImage[] {ImageIO.read(new File("data/apple.png")),ImageIO.read(new File("data/applesliced.png"))};

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void move()
	{
		if(yPos>maxHeight && !hasReachedMaximumHeight)
		{
			yPos-=speed;
			if(xDirection)
				xPos+=0.4*speed;
			else
				xPos-=0.4*speed;
		}
		else
		{
			hasReachedMaximumHeight=true;
		}
			
		
		if(hasReachedMaximumHeight && yPos<800)
		{
			yPos+=speed;
			if(xDirection)
				xPos+=0.4*speed;
			else
				xPos-=0.4*speed;
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
