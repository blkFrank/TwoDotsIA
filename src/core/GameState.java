package core;

import graphic.Texture;
import input.InputStatus;
import input.MouseInput;
import object.Cell;
import object.Color;
import object.Matrix;
import object.Status;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameState{

    private static Matrix matrix;

    private static MouseInput mi;

    private static Texture tex;

     public GameState() {
        matrix = new Matrix();
        mi = new MouseInput(matrix);
        tex = new Texture();
    }

    public static void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (int col = 0; col < matrix.getDim(); col++) {
            for (int row = 0; row < matrix.getDim(); row++) {
                if (matrix.getElement(col, row).getColor().equals(Color.BLUE))
                    g.drawImage(tex.getBlueCell(), row * 100, col * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.YELLOW))
                    g.drawImage(tex.getYellowCell(), row * 100, col * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.RED))
                    g.drawImage(tex.getRedCell(), row * 100, col * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.GREEN))
                    g.drawImage(tex.getGreenCell(), row * 100, col * 100, 100, 100, null);
                if (matrix.getElement(col, row).getColor().equals(Color.GREY))
                    g.drawImage(tex.getGreyCell(), row * 100, col * 100, 100, 100, null);

                if (matrix.getElement(col,row).getStatus().equals(Status.SELECTED))
                    g.drawImage(tex.getSelectedCell(), row * 100, col * 100, 100, 100, null);
            }
        }

        g.drawString("Score: " + matrix.getScore(), 250, 625);
    }

    public static MouseInput getMouseInput() { return mi; }

}
