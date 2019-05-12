import org.newdawn.slick.Image;

public abstract class GameObject implements GameObjectUtil {
	protected String type;
	protected float xPos;
	protected float yPos;
	protected int maxHeight;
	protected float speed;
	protected boolean isSliced;
	protected boolean isMovedOffScreen;
	protected Image[] images;
	Player player;
	@Override
	public Image[] getImages() {
		
		return images;
	}
	@Override
	public float getInitialSpeed() {
		return speed;
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public float getX() {
		return xPos;
	}
	@Override
	public float getY() {
		return yPos;
	}
	@Override
	public boolean ifMovedOffScreen() {
		return isMovedOffScreen;
	}
	@Override
	public boolean isSliced() {
		return isSliced;
	}
	@Override
	public int maxHeight() {
		return maxHeight;
	}
	public void slice()
	{
		this.isSliced=true;
		player.setScore(player.getScore()+10);
	}
	
	
	
}
