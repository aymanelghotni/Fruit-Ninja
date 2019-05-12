
public class FatalBomb extends GameObject {
	public FatalBomb(float speed) {
		this.type="FatalBomb";
		this.isMovedOffScreen=false;
		this.isSliced=false;
		this.speed=speed;
		player=player.getInstance();
		//this.maxHeight
		//this.xPos
		//this.yPos
	}
	public void slice()
	{
		this.isSliced=true;
		player.setLives(0);
	}
}
