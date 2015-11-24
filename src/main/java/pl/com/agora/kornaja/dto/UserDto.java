package pl.com.agora.kornaja.dto;

import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.UserGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P on 2015-11-23.
 */
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String adress;
    private Integer age;
    private List<UserGroupDto> userGroups;

    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.adress = user.getAdress().toString();
        this.age = user.getAge();
        if(user.getUserGroups() != null && !user.getUserGroups().isEmpty()) {
            userGroups = new ArrayList<>();
            for(UserGroup userGroup: user.getUserGroups()){
                userGroups.add(new UserGroupDto(userGroup));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<UserGroupDto> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroupDto> userGroups) {
        this.userGroups = userGroups;
    }
}
