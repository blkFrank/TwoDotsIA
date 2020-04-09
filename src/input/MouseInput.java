package input;

import core.GameConfig;
import object.Matrix;
import object.Status;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {

    private int mouseX, mouseY;

    private final int NUM_CELLS = 36;

    private Matrix matrix;

    public MouseInput(Matrix matrix) {
        mouseX = 0;
        mouseY = 0;
        this.matrix = matrix;
    }

    public void tick() {

    }

    public void mouseClicked(MouseEvent arg0) {
        System.out.println("Mouse pressed in: " + getX() + " " + getY());
        matrix.setElementStatus(getY(), getX(), Status.SELECTED);
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX() / 100);
        mouseY = (int)(e.getY() / 100);
    }

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

}

