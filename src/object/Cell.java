package object;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("cell")
public class Cell {

    @Param(0)
    private int row;

    @Param(1)
    private int col;

    @Param(2)
    private Color color;
    private Status status;

    public Cell() {
        this.row = 0;
        this.col = 0;
        this.color = null;
        this.status = null;
    }

    public Cell(Color color, Status status) {
        this.row = 0;
        this.col = 0;
        this.color = color;
        this.status = status;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
