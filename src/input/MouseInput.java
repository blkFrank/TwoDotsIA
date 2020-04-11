package input;

import object.Matrix;
import object.Status;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {

    private int mouseX, mouseY;

    private InputStatus status = InputStatus.RELEASED;

    private Matrix matrix;

    public MouseInput(Matrix matrix) {
        mouseX = 0;
        mouseY = 0;
        this.matrix = matrix;
    }

    public void tick() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setStatus(InputStatus.CLICKED);
        System.out.println("Mouse clicked in: " + getX() + " " + getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setStatus(InputStatus.PRESSED);
        System.out.println("Mouse pressed in: " + getX() + " " + getY());
        matrix.setElementStatus(getX(), getY(), Status.SELECTED);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setStatus(InputStatus.RELEASED);
        System.out.println("Mouse released in: " + getX() + " " + getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setStatus(InputStatus.MOVED);
        mouseX = (int)(e.getX() / 100);
        mouseY = (int)(e.getY() / 100);
    }

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

    public InputStatus getStatus() {
        return status;
    }

    public void setStatus(InputStatus status) {
        this.status = status;
    }
}

