package pl.com.agora.kornaja.domain;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.Set;

/**
 * Created by kornaja.
 */
@Entity
@Table(name = "USER_GROUP",uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "key2"}) })
public class UserGroup {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String key2;

    @ElementCollection
    @CollectionTable(name = "user_group_permissions")
    @Column(name = "permissions", nullable = true, insertable = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userGroups")
    private List<User> users;

    //region Getter && Setter
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

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
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
    //endregion
}
