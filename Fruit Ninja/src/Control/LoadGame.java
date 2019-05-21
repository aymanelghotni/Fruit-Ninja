package Control;



public class LoadGame implements Command {
	
    private GameController Game;

    public LoadGame(GameController Game){
    	this.Game = Game;
    }

    @Override
    public void execute() {
        Game.loadGame();
    }
}
