package pl.com.agora.kornaja.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kornaja.
 */
@Entity
public class UserGroup {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;

    @ManyToMany(mappedBy = "userGroups")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
