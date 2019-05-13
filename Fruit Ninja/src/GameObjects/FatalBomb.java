package GameObjects;
public class FatalBomb extends GameObject {
	public FatalBomb(float speed,int maxHeight,float xPos) {
		this.type="FatalBomb";
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
		player.setLives(0);
	}
}
