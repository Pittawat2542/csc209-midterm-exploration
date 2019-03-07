package midterm;

public class SinglyLinkedList {

    SinglyLinkedListNode head, tail;

    public void addToHead(int info) {
        if (isEmpty()) {
            head = tail = new SinglyLinkedListNode(info);
        } else {
            head = new SinglyLinkedListNode(info, head);
        }
    }

    public void addToTail(int info) {
        if (isEmpty()) {
            head = tail = new SinglyLinkedListNode(info);
        } else {
            tail.next = new SinglyLinkedListNode(info);
            tail = tail.next;
        }
    }

    public void addAt(int index, int info) {
        if (index == 0) {
            addToHead(info);
        } else if (index < 0) {
            System.out.println("Invalid index! Index must greater than zero");
        } else {
            SinglyLinkedListNode temp = head;
            for (int i = 1; i < index && temp != null; i++, temp = temp.next);

            if (temp == tail) {
                addToTail(info);
            } else if (temp == null) {
                System.out.println("Invalid index!");
            } else {
                temp.next = new SinglyLinkedListNode(info, temp.next);
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
        }
    }

    public void deleteFromTail() {
        if (isEmpty()) {
            System.out.println("Nothing to delete!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            SinglyLinkedListNode temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
    }

    public void deleteAt(int index) {
        if (isEmpty()) {
            System.out.println("Nothing to delete!");
        } else if (index == 0) {
            deleteFromHead();
        } else {
            SinglyLinkedListNode temp = head;
            for (int i = 1; i < index && temp != null; i++, temp = temp.next);

            if (temp == tail) {
                deleteFromTail();
            } else if (temp == null) {
                System.out.println("Invalid index!");
            } else {
                temp.next = temp.next.next;
            }
        }
    }

    public void printAllNode() {
        if (isEmpty()) {
            System.out.println("Notinh to print!");
        } else {
            SinglyLinkedListNode temp = head;
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
