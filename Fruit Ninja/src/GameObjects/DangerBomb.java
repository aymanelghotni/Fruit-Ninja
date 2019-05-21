package GameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DangerBomb extends GameObject {
	public DangerBomb(int speed,int maxHeight,float xPos,float factor) {
		this.type="DangerBomb";
		this.factor=factor;
		player=player.getInstance();
		this.random=new Random();
		xDirection=random.nextBoolean();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.radius=40;
		this.yPos=800;
		
	}
	public void slice()
	{
		this.isSliced=true;
		if(!Statics.arcade)
		{
			player.setLives(player.getLives()-1);
		}
		else
			player.setScore(player.getScore()-10);
		
	}
}
