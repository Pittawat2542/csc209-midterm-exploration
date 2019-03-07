package midterm;

import java.util.Stack;

public class Midterm {

    public static void main(String[] args) {
        // Test Todo - RandomAccessFile & OOP
        Todo todo1 = new Todo(0, "First todo", "Todo No. 1", true);
        Todo todo2 = new Todo(1, "Second todo", "Todo No. 2", false);
        TodoDB.writeToFile(todo1);
        TodoDB.writeToFile(todo2);
        TodoDB.readFromFile();
        TodoDB.readAllTitle();
        System.out.println("----------------------------------");

        // Test SinglyLinkedList
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addToHead(10);
        singlyLinkedList.addToTail(20);
        singlyLinkedList.addToTail(30);
        singlyLinkedList.deleteFromHead();
        singlyLinkedList.deleteFromTail();
        singlyLinkedList.addToTail(40);
        singlyLinkedList.addAt(1, 30);
        singlyLinkedList.deleteAt(1);
        singlyLinkedList.printAllNode();
        System.out.println("----------------------------------");

        // Test DoublyLinkedList
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addToHead(10);
        doublyLinkedList.addToTail(20);
        doublyLinkedList.addToTail(30);
        doublyLinkedList.deleteFromHead();
        doublyLinkedList.deleteFromTail();
        doublyLinkedList.addToTail(40);
        doublyLinkedList.addAt(1, 30);
        doublyLinkedList.deleteAt(1);
        doublyLinkedList.printAllNode();
        System.out.println("----------------------------------");

        // Test SparseTable
        // [SKIP]
        System.out.println("----------------------------------");

        // Test Stack
        MyStack stack = new MyStack(10);
        stack.push(10);
        System.out.println(stack.pop());
        stack.push(20);
        stack.peek();
        stack.size();
        stack.clear();
        stack.pop();
        System.out.println("----------------------------------");

        // Test Queue
        MyQueue queue = new MyQueue(10);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println(queue.dequeue());
        queue.enqueue(10);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("----------------------------------");

        // Test Matching Delimeter
        System.out.println(delemiterChecker("()()()()"));
        System.out.println(delemiterChecker("((){})"));
        System.out.println(delemiterChecker("2+12+23232+(23232+023232)"));
        System.out.println(delemiterChecker("(([){})]"));
        System.out.println("----------------------------------");

        // Test Maze
        int[][] maze = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
        {9, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 2, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        mazeSolver(maze, new Position(8, 3));
        System.out.println("----------------------------------");

        // Test Long Number Addition
        System.out.println(longNumberAddition("99", "1"));
        System.out.println(longNumberAddition("143", "60"));
        System.out.println(longNumberAddition("99", "600"));
        System.out.println(longNumberAddition("1000", "111"));
        System.out.println("----------------------------------");

        // Test Recursion
        printOneToN(10);
        System.out.println("");
        printNToOne(10);
        System.out.println("");
        printOddFirstTime(20);
        System.out.println("");
        printOddFirstTime(21);
        System.out.println("");
        System.out.println(fibonacci(10));
        System.out.println(division(10, 2));
        System.out.println(exponential(10, 2));
        System.out.println(logarithm(32, 2));
        System.out.println("----------------------------------");

    }

    public static boolean delemiterChecker(String str) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (s.equals("(") || s.equals("[") || s.equals("{") || s.equals("<")) {
                st.push(s);
            } else if (s.equals(")") || s.equals("]") || s.equals("}") || s.equals(">")) {
                if (st.empty()) {
                    return false;
                }
                String sCheck = st.pop();
                switch (s) {
                    case ")":
                        if (!sCheck.equals("(")) {
                            return false;
                        }
                        break;
                    case "]":
                        if (!sCheck.equals("[")) {
                            return false;
                        }
                        break;
                    case "}":
                        if (!sCheck.equals("{")) {
                            return false;
                        }
                        break;
                    case ">":
                        if (!sCheck.equals("<")) {
                            return false;
                        }
                }
            }
        }
        return true;
    }

    public static void mazeSolver(int[][] maze, Position startingPoint) {
        // 0 = can walk, 1 = wall, 2 = tried block, 3 = non-tried block (pushed, but haven't try), 9 = exit
        Position mouse = startingPoint;
        Stack<Position> backtrack = new Stack<>();
        backtrack.push(mouse);

        while (maze[mouse.row][mouse.col] != 9) {
            // See around if it can walk through
            if (maze[mouse.row - 1][mouse.col] == 0) {
                backtrack.push(new Position(mouse.row - 1, mouse.col));
                maze[mouse.row - 1][mouse.col] = 3;
            }
            if (maze[mouse.row][mouse.col + 1] == 0) {
                backtrack.push(new Position(mouse.row, mouse.col + 1));
                maze[mouse.row][mouse.col + 1] = 3;
            }
            if (maze[mouse.row + 1][mouse.col] == 0) {
                backtrack.push(new Position(mouse.row + 1, mouse.col));
                maze[mouse.row + 1][mouse.col] = 3;
            }
            if (maze[mouse.row][mouse.col - 1] == 0) {
                backtrack.push(new Position(mouse.row, mouse.col - 1));
                maze[mouse.row][mouse.col - 1] = 3;
            }

            // See around if it is exit
            if (maze[mouse.row - 1][mouse.col] == 9) {
                System.out.println("Found exit at " + (mouse.row - 1) + " " + mouse.col);
                break;
            } else if (maze[mouse.row][mouse.col + 1] == 9) {
                System.out.println("Found exit at " + mouse.row + " " + (mouse.col + 1));
                break;
            } else if (maze[mouse.row + 1][mouse.col] == 9) {
                System.out.println("Found exit at " + (mouse.row + 1) + ", " + mouse.col);
                break;
            } else if (maze[mouse.row][mouse.col - 1] == 9) {
                System.out.println("Found exit at " + mouse.row + " " + (mouse.col - 1));
                break;
            }

            Position out = backtrack.pop();
            mouse.row = out.row;
            mouse.col = out.col;
            maze[mouse.row][mouse.col] = 2;
        }
    }

    public static String longNumberAddition(String input1, String input2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < input1.length(); i++) {
            stack1.push(Integer.parseInt(input1.substring(i, i + 1)));
        }

        for (int i = 0; i < input2.length(); i++) {
            stack2.push(Integer.parseInt(input2.substring(i, i + 1)));
        }

        String result = "";
        int carry = 0;
        while (!stack1.empty() && !stack2.empty()) {
            int calculated = stack1.pop() + stack2.pop() + carry;

            if (carry == 1) {
                carry = 0;
            }

            if (calculated > 9) {
                calculated %= 10;
                carry = 1;
            }

            result = calculated + result;
        }

        if (!stack1.empty()) {
            int calculated = stack1.pop() + carry;
            if (carry == 1) {
                carry = 0;
            }

            if (calculated > 9) {
                calculated %= 10;
                carry = 1;
            }
            result = calculated + result;
        }

        if (!stack2.empty()) {
            int calculated = stack2.pop() + carry;
            if (carry == 1) {
                carry = 0;
            }

            if (calculated > 9) {
                calculated %= 10;
                carry = 1;
            }
            result = calculated + result;
        }

        if (stack1.empty() && stack2.empty() && carry == 1) {
            result = 1 + result;
        }

        return result;
    }

    public static void printOneToN(int n) {
        if (n > 0) {
            printOneToN(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void printNToOne(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            printNToOne(n - 1);
        }
    }

    public static void printOddAscending(int n) {
        if (n > 0) {
            if (n % 2 != 0) {
                printOddAscending(n - 2);
                System.out.print(n + " ");
            } else {
                printOddAscending(n - 1);
            }
        }
    }

    public static void printOddFirstTime(int n) {
        if (n % 2 == 0) {
            printOddAscendingVersionTwo(n - 1);
        } else {
            printOddAscendingVersionTwo(n);
        }
    }

    public static void printOddAscendingVersionTwo(int n) {
        if (n > 0) {
            printOddAscendingVersionTwo(n - 2);
            System.out.print(n + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int division(int a, int b) {
        if (a >= b) {
            return 1 + division(a - b, b);
        } else {
            return 0;
        }
    }

    public static int exponentialRecursion(int a, int b) {
        if (b > 0) {
            return a * exponentialRecursion(a, b - 1);
        } else {
            return 1;
        }
    }

    public static double exponential(int a, int b) {
        if (b < 0) {
            return 1.0 / exponentialRecursion(a, -b);
        } else {
            return exponentialRecursion(a, b);
        }
    }

    public static int logarithm(int n, int base) {
        if (n > 1) {
            return 1 + logarithm(n / base, base);
        } else {
            return 0;
        }
    }
}
