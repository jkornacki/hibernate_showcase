package pl.com.agora.kornaja.domain;

import java.util.List;

/**
 * Created by kornaja.
 */
public class TaskCategory {

    private Long id;
    private List<Task> tasks;
    private String name;
    private Task task;
    private TaskCategory parent;

    //region Getter && Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskCategory getParent() {
        return parent;
    }

    public void setParent(TaskCategory parent) {
        this.parent = parent;
    }
    //endregion
}
