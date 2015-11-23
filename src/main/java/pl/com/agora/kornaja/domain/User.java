package pl.com.agora.kornaja.domain;

import pl.com.agora.kornaja.domain.task.Task;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kornaja.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user__user_group",
            joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "user_group_id", nullable = false, updatable = false)
    )
    private List<UserGroup> userGroups;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @Embedded
    private UserAdress adress;

    //region Getter && Setter
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public User setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public UserAdress getAdress() {
        return adress;
    }

    public void setAdress(UserAdress adress) {
        this.adress = adress;
    }

    //endregion
}
