package midterm;

public class Todo {
    public static final int TITLE_SIZE = 20;
    public static final int BODY_SIZE = 100;
    public static final int RECORD_SIZE = 4 + TITLE_SIZE + BODY_SIZE + 1;
    
    private int id;
    private String title;
    private String body;
    private boolean done;

    public Todo(int id, String title, String body, boolean isDone) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.done = isDone;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean isDone) {
        this.done = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
}
