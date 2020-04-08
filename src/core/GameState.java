package core;

import graphic.Texture;
import input.MouseInput;
import object.Color;
import object.Matrix;

import java.awt.*;

public class GameState{

    private static Matrix matrix;

    private static MouseInput mi;

    private static Texture tex;

    public GameState() {
        matrix = new Matrix();
        mi = new MouseInput();
        tex = new Texture();
    }

    public static MouseInput getMouseInput() { return mi; }

    public void tick() {

    }

    public static void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (int col = 0; col < matrix.getDim(); col++) {
            for (int row = 0; row < matrix.getDim(); row++) {
                if (matrix.getElement(col, row).getColor().equals(Color.BLUE))
                    g.drawImage(tex.getBlueCell(), col * 100, row * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.YELLOW))
                    g.drawImage(tex.getYellowCell(), col * 100, row * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.RED))
                    g.drawImage(tex.getRedCell(), col * 100, row * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.GREEN))
                    g.drawImage(tex.getGreenCell(), col * 100, row * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.GREY))
                    g.drawImage(tex.getGreyCell(), col * 100, row * 100, 100, 100, null);
            }
        }
    }

}
