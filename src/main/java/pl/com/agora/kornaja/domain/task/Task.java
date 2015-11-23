package pl.com.agora.kornaja.domain.task;

import pl.com.agora.kornaja.domain.User;

import javax.persistence.*;
import java.util.Date;
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

    @Column(length = 500)
    private String title;

    @Column(name = "create_date")
    private Date createDate;

    @ElementCollection
    @CollectionTable(name = "task_tag",joinColumns = @JoinColumn(name = "tag_id"))
    @Column(length = 500)
    private List<String> tags;

    @ManyToOne
    private TaskCategory taskCategory;

    @ManyToOne
    private User user;

    //region Getter && Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //endregion
}
