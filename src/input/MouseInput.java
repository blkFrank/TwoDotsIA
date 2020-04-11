package input;

import object.Cell;
import object.Matrix;
import object.Status;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Vector;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {

    private int mouseX, mouseY;

    private Matrix matrix;

    Vector<Cell> cellSelected;

    public MouseInput(Matrix matrix) {
        mouseX = 0;
        mouseY = 0;
        this.matrix = matrix;
        cellSelected = new Vector<>();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released in: riga:" + getY() + " colonna:" + getX());
        System.out.println("CellSelected size: " + cellSelected.size());
        matrix.printMatrix();
        if(cellSelected.size() > 1 && matrix.ColorEqual(cellSelected) && matrix.validSelectedCells(cellSelected)){
            for (int i = 0; i < cellSelected.size(); i++) {
                matrix.setElementStatus(cellSelected.get(i).getRow(), cellSelected.get(i).getCol(), Status.DELETED);
            }

            matrix.setScore(cellSelected.size()*10);
            matrix.refreshMatrix();
        } else {
            for (int i = 0; i < cellSelected.size(); i++) {
                matrix.setElementStatus(cellSelected.get(i).getRow(), cellSelected.get(i).getCol(), Status.IDLE);
            }
        }
        matrix.printMatrix();
        cellSelected.clear();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int)(e.getX() / 100);
        mouseY = (int)(e.getY() / 100);
        System.out.println("Mouse dragged in: riga:" + getY() + " colonna:" + getX());
        if (!matrix.getElementStatus(getY(), getX()).equals(Status.SELECTED)) {
            matrix.setElementStatus(getY(), getX(), Status.SELECTED);
            cellSelected.add(matrix.getElement(getY(), getX()));
        }
    }

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }


    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { }

}

