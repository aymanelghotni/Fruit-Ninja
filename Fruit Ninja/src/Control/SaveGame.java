package Control;



public class SaveGame implements Command {
	
    private GameController Game;

    public SaveGame(GameController Game){
        this.Game = Game;
    }

    @Override
    public void execute() {
        Game.saveGame();
    }
}