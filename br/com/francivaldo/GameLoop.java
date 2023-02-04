package br.com.francivaldo;

public class GameLoop implements Runnable{
    private Thread thread;
    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;
    private IGame game;
    public GameLoop(IGame game){
        this.game = game;
    }
    @Override
    public void run() {
        running = true;
        boolean render = false;
        double nano = 1000000000.0;
        double firstTime = 0;
        double lastTime = System.nanoTime()/nano;
        double passedTime = 0;
        double unprocessedTime = 0;
        while(running){
            render = false;
            firstTime = System.nanoTime()/nano;
            passedTime = firstTime-lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            while(unprocessedTime>=UPDATE_CAP){
                unprocessedTime-=UPDATE_CAP;
                render = true;
                game.update();
            }
            if(render){
                game.render();
            }
            else{
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }
    public void start(){
        thread = new Thread(this);
        thread.run();
    }
    public void stop(){

    }
    public void dispose(){

    }

    
}
