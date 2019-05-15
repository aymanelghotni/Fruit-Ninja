package GameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatalBomb extends GameObject {
	public FatalBomb(int speed,int maxHeight,float xPos) {
		this.type="FatalBomb";
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
		try {
			images=new BufferedImage[] {ImageIO.read(new File("data/bomb2.png")),ImageIO.read(new File("data/explosion2.png"))};


		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public void slice()
	{
		this.isSliced=true;
		player.setLives(0);
	}
}
