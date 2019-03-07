package midterm;

public class SparseTable {

    SparseTableLinkedList[] row, col;

    public SparseTable(int row, int col) {
        this.row = new SparseTableLinkedList[row];
        this.col = new SparseTableLinkedList[col];

        for (SparseTableLinkedList sparseTableLinkedList : this.row) {
            sparseTableLinkedList = new SparseTableLinkedList();
        }

        for (SparseTableLinkedList sparseTableLinkedList : this.col) {
            sparseTableLinkedList = new SparseTableLinkedList();
        }
    }
    
    public void addItem(int info, int row, int col) {
        SparseTableNode newNode = new SparseTableNode(row, col, info, null, null);
//        this.row[row].addToTail(newNode);
//        this.col[col].addToTail(newNode);
    }

}
