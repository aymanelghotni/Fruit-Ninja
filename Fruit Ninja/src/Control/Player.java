package Control;
public class Player {
	private int lives;
	private int score;
	private int timer;
	private int highScore;
	private static Player instance;
	private boolean hasLost;
	private Player() {
		lives=3;
		score=0;
		timer=0;
		highScore=0;
	}
	
	
	public static Player getInstance()
	{
		if(instance==null)
			instance=new Player();
		return instance;
	}
	
	public boolean isHasLost() {
		return hasLost;
	}
	public void setHasLost(boolean hasLost) {
		this.hasLost = hasLost;
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	

	
}
