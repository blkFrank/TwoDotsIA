package core;

import graphic.Window;
import object.Matrix;
import object.Status;

import java.awt.Graphics;

public class GameManager implements Runnable {

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;

    private Window window;
    private GameState gs;

    private int FPS = 60;
    @SuppressWarnings("unused")
    private long targetTime = 1000 / FPS;

    public void start() {
        gs = new GameState();
        window = new Window("TwoDots", GameConfig.WIDTH, GameConfig.HEIGHT, GameConfig.SCALE, GameState.getMouseInput(), this);
        this.run();
    }

    @Override
    public void run() {
        running = true;
        boolean render = false;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime =  0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while(running)
        {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                tick();

                if (frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }
            if (render) {
                window.getPanel().repaint();
                frames++;
            }
        }
    }

    public void tick() {
        gs.getMouseInput().tick();
        gs.tick();
    }

    public void render(Graphics g) {
        gs.render(g);
    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.start();

        Matrix matrix = new Matrix();

        matrix.printMatrix();

        matrix.setElementStatus(0,0, Status.DELETED);
        matrix.setElementStatus(0,1, Status.DELETED);
        matrix.setElementStatus(1,1, Status.DELETED);
        matrix.setElementStatus(2,1, Status.DELETED);

        matrix.refreshMatrix();

        matrix.printMatrix();
    }

}
