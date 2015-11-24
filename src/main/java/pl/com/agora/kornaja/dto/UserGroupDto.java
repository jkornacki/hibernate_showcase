package pl.com.agora.kornaja.dto;

import pl.com.agora.kornaja.domain.Permission;
import pl.com.agora.kornaja.domain.UserGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P on 2015-11-23.
 */
public class UserGroupDto {

    private Long id;
    private String name;
    private List<String> permission;

    public UserGroupDto(UserGroup userGroup) {
        this.id = userGroup.getId();
        this.name = userGroup.getName();
        if(userGroup.getPermissions() != null && !userGroup.getPermissions().isEmpty()) {
            permission = new ArrayList<>();
            for(Permission permission: userGroup.getPermissions()) {
                this.permission.add(permission.toString());
            }
        }
    }

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

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }
}
