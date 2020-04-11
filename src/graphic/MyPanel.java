package graphic;


import core.GameManager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    GameManager gm;
    private Font font;

    public MyPanel(int width, int height, int scale, GameManager gm) {
        this.gm = gm;
        Dimension s = new Dimension((int)width * scale, (int) height * scale + 50);
        font = new Font("Comic Sans Ms",Font.BOLD, 30);
        this.setPreferredSize(s);
        this.setMaximumSize(s);
        this.setMinimumSize(s);
    }

    public void makePanelFocusable() {
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gm.render(g);
    }

}
