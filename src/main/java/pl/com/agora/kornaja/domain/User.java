package pl.com.agora.kornaja.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

/**
 * Created by kornaja.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true, length = 128)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user__user_group", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)
    }, uniqueConstraints = {
            @UniqueConstraint(columnNames = {"user_id", "group_id"})
    })
    private List<UserGroup> userGroups;


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

    public UserAdress getAdress() {
        return adress;
    }

    public void setAdress(UserAdress adress) {
        this.adress = adress;
    }
    //endregion
}
