package pl.com.agora.kornaja.domain;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by kornaja.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Task {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task", cascade = CascadeType.ALL)
    private TaskCategory category;
    private String title;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ElementCollection
    @CollectionTable(name = "task_tags")
    @Column(name = "tags")
    private List<String> tags;

    //region Getter && Setter
    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public TaskCategory getCategory() {
        return category;
    }

    public Task setCategory(TaskCategory category) {
        this.category = category;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task setStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    //endregion
}
