package GameObjects;
public class Melon extends GameObject {
	public Melon(float speed,int maxHeight,float xPos) {
		this.type="Melon";
		this.isMovedOffScreen=false;
		player=player.getInstance();
		this.isSliced=false;
		this.speed=speed;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
	}
	
	public void move()
	{
		if(yPos>maxHeight && !hasReachedMaximumHeight)
		{
			yPos-=speed;	
		}
		if(yPos<=maxHeight)
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
