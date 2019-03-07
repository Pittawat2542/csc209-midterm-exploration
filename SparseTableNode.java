package midterm;

public class SparseTableNode {

    int row, col, info;
    SparseTableNode nextRow, nextCol;

    public SparseTableNode(int row, int col, int info, SparseTableNode nextRow, SparseTableNode nextCol) {
        this.row = row;
        this.col = col;
        this.info = info;
        this.nextRow = nextRow;
        this.nextCol = nextCol;
    }
}
