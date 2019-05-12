
public class Apple extends GameObject {
	public Apple(float speed) {
		this.type="Apple";
		this.isMovedOffScreen=false;
		this.isSliced=false;
		player=player.getInstance();
		this.speed=speed;
		//this.maxHeight
		//this.xPos
		//this.yPos
	}
}
