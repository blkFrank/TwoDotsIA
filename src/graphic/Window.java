package graphic;

import core.GameManager;
import input.MouseInput;

public class Window {

    private MyFrame frame;
    private MyPanel panel;

    public Window(String title, int width, int heigth, int scale, MouseInput mi, GameManager gm) {
        frame = new MyFrame(title);
        panel = new MyPanel(width, heigth, scale, gm);

        panel.addMouseListener(mi);
        panel.addMouseMotionListener(mi);
        panel.addMouseWheelListener(mi);
        frame.addContent(panel);
        panel.makePanelFocusable();
    }

    public MyPanel getPanel() { return panel; }
}
