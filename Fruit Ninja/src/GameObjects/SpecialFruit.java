package GameObjects;

import java.util.Random;

public class SpecialFruit extends GameObject {
	int slices;
	public SpecialFruit(int speed,int maxHeight,float xPos,float factor) {
		this.type="SpecialFruit";
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
		
		this.slices--;
		player.setScore(player.getScore()+5);
		Statics.speedFactor=0.1f;
		if(slices==0)
		{
			this.isSliced=true;
			Statics.speedFactor=1;
		}
			
	}
}
