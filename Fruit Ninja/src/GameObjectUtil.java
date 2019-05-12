import org.newdawn.slick.Image;

public interface GameObjectUtil {
		public String getType();
		public float getX();
		public float getY();
		public int maxHeight();
		public float getInitialSpeed();
		public boolean isSliced();
		public boolean ifMovedOffScreen();
		public Image[] getImages();
		public void slice();
		
}
