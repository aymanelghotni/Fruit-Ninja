package GameObjects;
public class Orange extends GameObject{
	public Orange(float speed,int maxHeight,float xPos) {
		this.type="Orange";
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
