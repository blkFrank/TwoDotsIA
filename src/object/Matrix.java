package object;

import java.util.Vector;

public class Matrix {

    private static int dim = 6;

    private Vector<Vector<Cell>> matrix;

    public Matrix(){
        matrix = new Vector<>();

        for (int i = 0; i<dim; i++){
            Vector<Cell> col = new Vector<>();
            for (int j = 0; j<dim; j++) {
                Cell c = new Cell(Color.randomColor(), Status.IDLE);
                col.add(c);
            }
            matrix.add(col);
        }

        refreshCellPosition();
    }

    public void refreshMatrix() {
        for (int i = 0; i < dim; i++) {
            matrix.get(i).removeIf(cell -> (cell.getStatus().equals(Status.DELETED)));
            if (matrix.get(i).size() < 6) {
                int cont = 6 - matrix.get(i).size();
                while (cont != 0) {
                    Cell c = new Cell(Color.randomColor(), Status.IDLE);
                    matrix.get(i).add(0, c);
                    cont--;
                }
            }
        }
        refreshCellPosition();
    }

    public void refreshCellPosition() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix.get(i).get(j).setCol(i);
                matrix.get(i).get(j).setRow(j);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print("[" + matrix.get(j).get(i).getRow() + "," + matrix.get(j).get(i).getCol() + "] ");
            }

            for (int j = 0; j < dim; j++) {
                System.out.print(matrix.get(j).get(i).getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void setElementStatus(int row, int col, Status st){
        matrix.get(col).get(row).setStatus(st);
    }

    public Status getElementStatus(int row, int col) { return matrix.get(col).get(row).getStatus(); }

    public Cell getElement(int row, int col) { return matrix.get(col).get(row); }

    public int getDim() {
        return dim;
    }

    public Vector<Vector<Cell>> getMatrix() {
        return matrix;
    }
}