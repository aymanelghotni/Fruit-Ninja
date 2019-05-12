
public class DangerBomb extends GameObject {
	public DangerBomb(float speed) {
		this.type="DangerBomb";
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
		player.setLives(player.getLives()-1);
	}
}
