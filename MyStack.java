package midterm;

public class MyStack {

    int[] info;
    int top;

    public MyStack(int size) {
        info = new int[size];
    }

    public void push(int info) {
        if (!isFull()) {
            this.info[top++] = info;
        } else {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return info[--top];
        } else {
            System.out.println("Nothing to pop from stack!");
            return Integer.MAX_VALUE;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return info[top - 1];
        } else {
            System.out.println("Nothing to peek at stack!");
            return Integer.MAX_VALUE;
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == info.length;
    }

    public int size() {
        return top;
    }

    public void clear() {
        top = 0;
    }
}
