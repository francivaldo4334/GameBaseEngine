package br.com.francivaldo;

public abstract class IGame {
    private IGameManager gameManager;
    public IGame(IGameManager gameManager){
        this.gameManager = gameManager;
    }
    public abstract void render();
    public abstract void update();
    public IGameManager getGameManager(){
        return gameManager;
    }
}
