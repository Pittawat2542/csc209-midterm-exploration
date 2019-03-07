package midterm;

public class DoublyLinkedList {

    DoublyLinkedListNode head, tail;

    public void addToHead(int info) {
        if (isEmpty()) {
            head = tail = new DoublyLinkedListNode(info);
        } else {
            head = new DoublyLinkedListNode(info, head, null);
            head.next.prev = head;
        }
    }

    public void addToTail(int info) {
        if (isEmpty()) {
            head = tail = new DoublyLinkedListNode(info);
        } else {
            tail.next = new DoublyLinkedListNode(info, null, tail);
            tail = tail.next;
        }
    }

    public void addAt(int index, int info) {
        if (index == 0) {
            addToHead(info);
        } else if (index < 0) {
            System.out.println("Invalid index! Index must greater than zero");
        } else {
            DoublyLinkedListNode temp = head;
            for (int i = 1; i <= index && temp != null; i++, temp = temp.next);

            if (temp == null) {
                System.out.println("Invalid index!");
            } else {
                temp.prev = temp.prev.next = new DoublyLinkedListNode(info, temp, temp.prev);
            }
        }
    }

    public void deleteFromHead() {
        if (isEmpty()) {
            System.out.println("Nothing to delete!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromTail() {
        if (isEmpty()) {
            System.out.println("Nothing to delete!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    public void deleteAt(int index) {
        if (isEmpty()) {
            System.out.println("Nothing to delete!");
        } else if (index == 0) {
            deleteFromHead();
        } else {
            DoublyLinkedListNode temp = head;
            for (int i = 1; i <= index && temp != null; i++, temp = temp.next);

            if (temp == tail) {
                deleteFromTail();
            } else if (temp == null) {
                System.out.println("Invalid index!");
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

    public void printAllNode() {
        if (isEmpty()) {
            System.out.println("Notinh to print!");
        } else {
            DoublyLinkedListNode temp = head;
            while (temp != null) {
                System.out.println(temp.info);
                temp = temp.next;
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
