package pl.com.agora.kornaja.domain;

import java.util.List;

/**
 * Created by kornaja.
 */
public class User {

    private Long id;
    private List<UserGroup> userGroups;
    private String login;
    private String password;

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
    //endregion
}
