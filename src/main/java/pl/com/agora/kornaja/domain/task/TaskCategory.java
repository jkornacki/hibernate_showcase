package pl.com.agora.kornaja.domain.task;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kornaja.
 */
@Entity
public class TaskCategory {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "taskCategory",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Task> tasks;

    private String name;

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
}
