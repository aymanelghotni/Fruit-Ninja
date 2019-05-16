package GameObjects;



import java.util.Random;





public class Orange extends GameObject{
	public Orange(int speed,int maxHeight,float xPos,float factor) {
		this.type="Orange";
		this.random=new Random();
		this.factor=factor;
		xDirection=random.nextBoolean();
		player=player.getInstance();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		this.radius=40;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
		
	}
	
	public void move()
	{
		if(yPos>maxHeight && !hasReachedMaximumHeight)
		{
			yPos-=speed;
			if(xDirection)
				xPos+=factor*speed;
			else
				xPos-=factor*speed;
		}
		else
		{
			hasReachedMaximumHeight=true;
		}
			
		
		if(hasReachedMaximumHeight && yPos<800)
		{
			yPos+=speed;
			if(xDirection)
				xPos+=factor*speed;
			else
				xPos-=factor*speed;
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
