package graphic;

import java.awt.image.BufferedImage;

public class Texture {

    private BufferedImage yellowCell = null;
    private BufferedImage redCell = null;
    private BufferedImage greenCell = null;
    private BufferedImage greyCell = null;
    private BufferedImage blueCell = null;
    private BufferedImage selectedCell = null;

    BufferedImageLoader loader = new BufferedImageLoader();

    public Texture() {
        yellowCell = loader.loadBufferedImage("/yellow.png");
        redCell = loader.loadBufferedImage("/red.png");
        greenCell = loader.loadBufferedImage("/green.png");
        greyCell = loader.loadBufferedImage("/grey.png");
        blueCell = loader.loadBufferedImage("/blue.png");
        selectedCell = loader.loadBufferedImage("/selected.png");
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

    public BufferedImage getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(BufferedImage selectedCell) {
        this.selectedCell = selectedCell;
    }

    public BufferedImageLoader getLoader() {
        return loader;
    }

    public void setLoader(BufferedImageLoader loader) {
        this.loader = loader;
    }
}
