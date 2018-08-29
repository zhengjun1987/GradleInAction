package main.java.com.zhengjun.cn.app;

public class ToDoItem implements Comparable<ToDoItem> {
    private Long id;
    private String name;
    private Boolean completed;

    public ToDoItem(Long id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    @Override
    public int compareTo(ToDoItem o) {
        return (int) (this.id - o.id);
    }
}
