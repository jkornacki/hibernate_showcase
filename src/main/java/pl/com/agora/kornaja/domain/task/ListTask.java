package pl.com.agora.kornaja.domain.task;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by P on 2015-11-23.
 */
@Entity
@DiscriminatorValue("list")
public class ListTask extends Task {

    @ElementCollection
    @JoinTable(name = "task_list_subtask",
            joinColumns = @JoinColumn(name = "task_id"))
    @MapKeyColumn(name = "description",columnDefinition =  "VARCHAR(500)")
    @Column(name = "is_done")
    private Map<String,Boolean> subtask;

    public Map<String, Boolean> getSubtask() {
        return subtask;
    }

    public void setSubtask(Map<String, Boolean> subtask) {
        this.subtask = subtask;
    }
}
