package midterm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TodoDB {

    public static final String FILE_NAME = "todo.dat";

    public static boolean writeToFile(Todo todo) {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw"); // mode "rw" for read-write
            raf.seek(raf.length()); // seek to end of the file -> not overwrite the existing information
            raf.writeInt(todo.getId());
            String title = todo.getTitle();
            title += "                                        "; // to make sure that title always has the same size (40 bytes)
            raf.write(title.getBytes(), 0, Todo.TITLE_SIZE); // turn string into byte array before write data
            String body = todo.getBody();
            body += "                                                                                                                        ";
            raf.write(body.getBytes(), 0, Todo.BODY_SIZE);
            raf.writeBoolean(todo.isDone());
            raf.close();
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public static void readFromFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r"); // mode "r" for read
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                byte[] title = new byte[Todo.TITLE_SIZE];
                raf.read(title, 0, Todo.TITLE_SIZE);
                byte[] body = new byte[Todo.BODY_SIZE];
                raf.read(body, 0, Todo.BODY_SIZE);
                boolean done = raf.readBoolean();
                System.out.println(id + " " + (new String(title)).trim() + ": " + (new String(body)).trim() + " done: " + done);
            }

            raf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Some errors occur during processing file!");
        }
    }

    public static void readAllTitle() {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r");
            raf.seek(4); // seek to skip the id
            
            while (raf.getFilePointer() < raf.length()) {
                byte[] title = new byte[Todo.TITLE_SIZE];
                raf.read(title, 0, Todo.TITLE_SIZE);
                System.out.println("Title: " + (new String(title)).trim());
                raf.seek(raf.getFilePointer() + Todo.RECORD_SIZE - Todo.TITLE_SIZE);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Some errors occur during processing file!");
        }
    }
}
