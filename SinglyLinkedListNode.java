package midterm;

public class SinglyLinkedListNode {

    int info;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int info) {
        this.info = info;
    }

    public SinglyLinkedListNode(int info, SinglyLinkedListNode next) {
        this.info = info;
        this.next = next;
    }
}
