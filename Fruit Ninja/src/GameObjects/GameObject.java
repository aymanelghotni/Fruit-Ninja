package GameObjects;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.newdawn.slick.Image;

import com.sun.tools.javac.Main;

import Control.Player;



public abstract class GameObject implements GameObjectUtil {
	protected String type;
	protected float xPos;
	protected float yPos;
	protected float radius;
	protected boolean xDirection;
	Random random;
	protected int maxHeight;
	protected boolean hasReachedMaximumHeight;
	protected int speed;
	float factor;
	protected boolean isSliced;
	protected boolean isMovedOffScreen;
	protected BufferedImage[] images;
	Player player;
	@Override
	public BufferedImage[] getImages() {
		
		return images;
	}
	@Override
	public float getInitialSpeed() {
		return speed;
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public float getX() {
		return xPos;
	}
	@Override
	public float getY() {
		return yPos;
	}
	@Override
	public boolean ifMovedOffScreen() {
		return isMovedOffScreen;
	}
	@Override
	public boolean isSliced() {
		return isSliced;
	}
	@Override
	public int maxHeight() {
		return maxHeight;
	}
	public void slice()
	{
		this.isSliced=true;
		player.setScore(player.getScore()+10);
	}
	
	@Override
	public void setRadius(float radius) {
		this.radius=radius;
		
	}
	@Override
	public void setX(float xPos) {
		this.xPos=xPos;
		
	}
	@Override
	public void setY(float yPos) {
		this.yPos=yPos;
		
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	public void setMovedOffScreen(boolean isMovedOffScreen) {
		this.isMovedOffScreen = isMovedOffScreen;
	}
	
	public void move()
	{
		
		if(yPos>maxHeight && !hasReachedMaximumHeight)
		{
			yPos-=speed*Statics.speedFactor;
			if(xDirection)
				xPos+=factor*speed*Statics.speedFactor;
			else
				xPos-=factor*speed;
				
		}
		else
		{
			hasReachedMaximumHeight=true;
		}
			
		
		if(hasReachedMaximumHeight && yPos<800)
		{
			yPos+=speed*Statics.speedFactor;
			if(xDirection)
				xPos+=factor*speed*Statics.speedFactor;
			else
				xPos-=factor*speed*Statics.speedFactor;
		}
			
		if(yPos>=800)
		{
			isMovedOffScreen=true;
		}
		
	}
	
	public float getRadius() {
		return radius;
	}
	public void setxDirection(boolean xDirection) {
		this.xDirection = xDirection;
	}
	public boolean getXDirection()
	{
		return xDirection;
	}
	
}
