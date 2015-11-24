package pl.com.agora.kornaja.controler.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.agora.kornaja.domain.task.Task;
import pl.com.agora.kornaja.dto.TaskDto;
import pl.com.agora.kornaja.dto.UserDto;
import pl.com.agora.kornaja.dto.UserTaskDto;
import pl.com.agora.kornaja.repository.UserRepositoryCustom;
import pl.com.agora.kornaja.service.UserRepositoryService;

import java.util.List;

/**
 * Created by P on 2015-11-23.
 */
@RestController
public class UserRestControler {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;
    @Autowired
    private UserRepositoryService userRepositoryService;

    @RequestMapping("/users")
    public List<UserDto> getAllUserFix() {
        return userRepositoryService.getAllUsers();
    }

    @RequestMapping("/user/login/{login}")
    public UserDto findUser(@PathVariable("login") String login) {
        return userRepositoryService.getUserByLogin(login);
    }

    @RequestMapping("/user/{id}")
    public UserDto findUser(@PathVariable("id") Long id) {
        return userRepositoryService.getUserById(id);
    }

    @RequestMapping("/users/group/{id}")
    public List<UserDto> findByUserGroup(@PathVariable("id") Long id) {
        return userRepositoryService.findUserByGroup(id);
    }

    @RequestMapping("/users/group_id/{id}")
    public List<UserDto> findByUserGroup2(@PathVariable("id") Long id) {
        return userRepositoryService.findUserByGroupId(id);
    }

    @RequestMapping("/user/{id}/user_and_tasks")
    public List<TaskDto> findUserAndTasks(@PathVariable("id") Long id) {
        return userRepositoryService.getUserAndTask(id);
    }

    @RequestMapping("/user/{id}/tasks")
    public List<TaskDto> findUserTasks(@PathVariable("id") Long id) {
        List<Task> tasks = userRepositoryCustom.findUserTasks(id);
        return userRepositoryService.getTaskDtos(tasks);
    }

    @RequestMapping("user_adult")
    public List<UserDto> getAdultUsers() {
        return userRepositoryService.getAdultUser();
    }

    @RequestMapping("/user_adult/tasks")
    public List<TaskDto> getTaskAdultUsers() {
        List<Task> tasks = userRepositoryCustom.findTaskAdultUsers();
        return userRepositoryService.getTaskDtos(tasks);
    }

    @RequestMapping("/user_tasks")
    public List<UserTaskDto> getUserTask() {
        return userRepositoryService.getUserTasks();
    }

}
