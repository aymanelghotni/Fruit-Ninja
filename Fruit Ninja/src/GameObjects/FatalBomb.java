package GameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatalBomb extends GameObject {
	public FatalBomb(int speed,int maxHeight,float xPos,float factor) {
		this.type="FatalBomb";
		this.factor=factor;
		this.random=new Random();
		player=player.getInstance();
		xDirection=random.nextBoolean();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
		this.radius=60;
		
	}
	public void slice()
	{
		this.isSliced=true;
		if(Statics.arcade)
		{
			player.setScore(player.getScore()-30);
		}
		else
			player.setLives(0);
		
	}
}
