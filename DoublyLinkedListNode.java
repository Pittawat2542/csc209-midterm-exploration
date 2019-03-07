package midterm;

public class DoublyLinkedListNode {

    int info;
    DoublyLinkedListNode next, prev;

    public DoublyLinkedListNode(int info) {
        this.info = info;
    }

    public DoublyLinkedListNode(int info, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

}
