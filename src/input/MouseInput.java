package input;

import core.GameState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {

    private int mouseX, mouseY;

    private GameState gs;

    public MouseInput(GameState gs) {
        mouseX = 0;
        mouseY = 0;
        this.gs = gs;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released in: riga:" + getY() + " colonna:" + getX());
        gs.checkMove();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int)(e.getX() / 100);
        mouseY = (int)(e.getY() / 100);
        System.out.println("Mouse dragged in: riga:" + getY() + " colonna:" + getX());
        gs.doMove();
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
    public void mouseMoved(MouseEvent e) { }

}

