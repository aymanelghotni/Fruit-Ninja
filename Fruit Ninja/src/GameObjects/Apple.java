package GameObjects;

import java.util.Random;


public class Apple extends GameObject {
	public Apple(int speed,int maxHeight,float xPos,float factor) {
		this.type="Apple";
		player=player.getInstance();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.factor=factor;
		this.speed=speed;
		this.radius=35;
		this.random=new Random();
		xDirection=random.nextBoolean();
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
		
	}
	
	public void move()
	{
		if(yPos>maxHeight && !hasReachedMaximumHeight)
		{
			yPos-=speed*Statics.speedFactor;
			if(xDirection)
			{
				xPos+=factor*speed*Statics.speedFactor;
			}
				
			else
			{
				xPos-=factor*speed*Statics.speedFactor;
			}
				
		}
		else
		{
			hasReachedMaximumHeight=true;
		}
			
		
		if(hasReachedMaximumHeight && yPos<800)
		{
			yPos+=speed*Statics.speedFactor;
			if(xDirection)
			{
				xPos+=factor*speed*Statics.speedFactor;
			}
				
			else
			{
				xPos-=factor*speed*Statics.speedFactor;
			}
				
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
