package core;

import graphic.Texture;
import input.DLVSolver;
import input.MouseInput;
import object.Cell;
import object.Color;
import object.Matrix;
import object.Status;

import java.awt.*;
import java.util.Vector;

public class GameState{

    private static Matrix matrix;

    private static MouseInput mi;

    private DLVSolver solver;

    private static Texture tex;

     public GameState() {
        matrix = new Matrix();
        mi = new MouseInput(this);
        solver = new DLVSolver(matrix);
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

    public void tick() {
        Vector<Cell> cellSelected = solver.initCellSelected();

        for (int i = 0; i < cellSelected.size(); i++) {
            matrix.setElementStatus(cellSelected.get(i).getRow(), cellSelected.get(i).getCol(), Status.DELETED);
            try {
                wait(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        matrix.setScore(cellSelected.size()*10);

        solver.refreshProgramFact();
    }

    public void doMove() {
        if (!matrix.getElementStatus(mi.getY(), mi.getX()).equals(Status.SELECTED)) {
            matrix.setElementStatus(mi.getY(), mi.getX(), Status.SELECTED);
            matrix.addCellSelected(matrix.getElement(mi.getY(), mi.getX()));
        }
    }

    public void checkMove() {
        matrix.printMatrix();
        if(matrix.getElementOfCellSelected().size() > 1 && matrix.ColorEqual(matrix.getElementOfCellSelected()) && matrix.validSelectedCells(matrix.getElementOfCellSelected())){
            for (int i = 0; i < matrix.getElementOfCellSelected().size(); i++) {
                matrix.setElementStatus(matrix.getElementOfCellSelected(i).getRow(), matrix.getElementOfCellSelected(i).getCol(), Status.DELETED);
            }

            matrix.setScore(matrix.getElementOfCellSelected().size()*10);
            matrix.refreshMatrix();
        } else {
            for (int i = 0; i < matrix.getElementOfCellSelected().size(); i++) {
                matrix.setElementStatus(matrix.getElementOfCellSelected(i).getRow(), matrix.getElementOfCellSelected(i).getCol(), Status.IDLE);
            }
        }
        matrix.printMatrix();
        matrix.clearCellSelected();
    }

    public static MouseInput getMouseInput() { return mi; }

}
