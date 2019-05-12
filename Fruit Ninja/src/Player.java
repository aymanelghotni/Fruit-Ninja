
public class Player {
	private int lives;
	private int score;
	private int timer;
	private int highScore;
	private static Player instance;
	private Player() {
		lives=3;
		score=0;
		timer=0;
		highScore=0;
	}
	
	public Player getInstance()
	{
		if(instance==null)
			return new Player();
		else
			return instance;
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
