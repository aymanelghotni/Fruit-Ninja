package GameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DangerBomb extends GameObject {
	public DangerBomb(int speed,int maxHeight,float xPos) {
		this.type="DangerBomb";
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
		try {
			images=new BufferedImage[] {ImageIO.read(new File("data/bomb1.png")),ImageIO.read(new File("data/explosion.png"))};


		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public void slice()
	{
		this.isSliced=true;
		player.setLives(player.getLives()-1);
	}
}
