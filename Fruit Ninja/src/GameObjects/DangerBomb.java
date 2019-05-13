package GameObjects;
public class DangerBomb extends GameObject {
	public DangerBomb(float speed,int maxHeight,float xPos) {
		this.type="DangerBomb";
		player=player.getInstance();
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		this.maxHeight=maxHeight;
		this.xPos=xPos;
		this.yPos=800;
	}
	public void slice()
	{
		this.isSliced=true;
		player.setLives(player.getLives()-1);
	}
}
