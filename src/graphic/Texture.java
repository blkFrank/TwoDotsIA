package graphic;

import java.awt.image.BufferedImage;

public class Texture {

    private BufferedImage yellowCell = null;
    private BufferedImage redCell = null;
    private BufferedImage greenCell = null;
    private BufferedImage greyCell = null;
    private BufferedImage blueCell = null;

    BufferedImageLoader loader = new BufferedImageLoader();

    public Texture() {
        yellowCell = loader.loadBufferedImage("/home/francesco/IdeaProjects/TwoDotsIA/res/yellow.png");
        redCell = loader.loadBufferedImage("/home/francesco/IdeaProjects/TwoDotsIA/res/red.png");
        greenCell = loader.loadBufferedImage("/home/francesco/IdeaProjects/TwoDotsIA/res/green.png");
        greyCell = loader.loadBufferedImage("/home/francesco/IdeaProjects/TwoDotsIA/res/grey.png");
        blueCell = loader.loadBufferedImage("/home/francesco/IdeaProjects/TwoDotsIA/res/blue.png");
    }

    public BufferedImage getYellowCell() {
        return yellowCell;
    }

    public void setYellowCell(BufferedImage yellowCell) {
        this.yellowCell = yellowCell;
    }

    public BufferedImage getRedCell() {
        return redCell;
    }

    public void setRedCell(BufferedImage redCell) {
        this.redCell = redCell;
    }

    public BufferedImage getGreenCell() {
        return greenCell;
    }

    public void setGreenCell(BufferedImage greenCell) {
        this.greenCell = greenCell;
    }

    public BufferedImage getGreyCell() {
        return greyCell;
    }

    public void setGreyCell(BufferedImage greyCell) {
        this.greyCell = greyCell;
    }

    public BufferedImage getBlueCell() {
        return blueCell;
    }

    public void setBlueCell(BufferedImage blueCell) {
        this.blueCell = blueCell;
    }
}
