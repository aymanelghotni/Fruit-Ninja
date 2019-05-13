package GameObjects;
public class Apple extends GameObject {
	public Apple(float speed,int maxHeight,float xPos) {
		this.type="Apple";
		player=player.getInstance();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
	}
	
	public void move()
	{
		if(yPos>maxHeight)
		{
			yPos-=speed;	
		}
		else
		{
			hasReachedMaximumHeight=true;
		}
			
		
		if(hasReachedMaximumHeight && yPos<800)
		{
			yPos+=speed;
		}
		if(yPos>=800 && !isSliced)
		{
			player.setLives(player.getLives()-1);
		}
			
		
	}
}
