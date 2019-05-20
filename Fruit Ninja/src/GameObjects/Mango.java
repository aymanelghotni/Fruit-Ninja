package GameObjects;

import java.util.Random;

public class Mango extends GameObject {
	int slices;
	public Mango(int speed,int maxHeight,float xPos,float factor) {
		this.type="Mango";
		player=player.getInstance();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.factor=factor;
		this.speed=speed;
		this.radius=50;
		this.random=new Random();
		this.slices=10;
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
	
	public void slice()
	{
		
		this.isSliced=true;
		player.setScore(player.getScore()+30);
			
			
	}
}
