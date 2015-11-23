package pl.com.agora.kornaja.domain;

import org.hibernate.annotations.BatchSize;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import java.util.Map;

/**
 * Created by kornaja.
 */
@Entity
@DiscriminatorValue(value = "list")
public class ListTask extends Task {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "task_subtask",
            joinColumns = @JoinColumn(name = "task_id"))
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @BatchSize(size = 20)
    private Map<String, Boolean> subtask;

    public Map<String, Boolean> getSubtask() {
        return subtask;
    }

    public void setSubtask(Map<String, Boolean> subtask) {
        this.subtask = subtask;
    }
}
