package pl.com.agora.kornaja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.UserGroup;
import pl.com.agora.kornaja.domain.task.ListTask;
import pl.com.agora.kornaja.domain.task.NoteTask;
import pl.com.agora.kornaja.domain.task.Task;
import pl.com.agora.kornaja.dto.TaskDto;
import pl.com.agora.kornaja.dto.UserDto;
import pl.com.agora.kornaja.dto.UserTaskDto;
import pl.com.agora.kornaja.repository.UserCrudRepository;
import pl.com.agora.kornaja.repository.UserRepositoryCustom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by P on 2015-11-24.
 */
@Service
public class UserRepositoryService {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    public List<UserDto> getAllUsers() {
        return ((List<User>) (userCrudRepository.findAll())).stream()
                .map(user -> new UserDto(user))
                .collect(Collectors.toList());
    }

    public UserDto getUserByLogin(@PathVariable("login") String login) {
        User user = userCrudRepository.findUserByLogin(login);
        if ( user != null ) {
            return new UserDto(user);
        }
        return null;
    }

    public UserDto getUserById(@PathVariable("id") Long id) {
        User user = userCrudRepository.findOne(id);
        if ( user != null ) {
            return new UserDto(user);
        }
        return null;
    }

    public List<UserDto> findUserByGroup(@PathVariable("id") Long id) {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(id);

        return userCrudRepository.findUsersByUserGroups(userGroup).stream()
                .map(user -> new UserDto((User) user))
                .collect(Collectors.toList());
    }

    public List<UserDto> findUserByGroupId(@PathVariable("id") Long id) {
        return userCrudRepository.findUsersByUserGroups(id).stream()
                .map(user -> new UserDto((User) user))
                .collect(Collectors.toList());
    }

    public List<TaskDto> getUserAndTask(@PathVariable("id") Long id) {
        List<Object> tasks = userRepositoryCustom.findUserAndTasks(id);
        return tasks.stream()
                .map(obj -> {
                    Object[] objects = (Object[]) obj;
                    for (Object o : objects) {
                        if ( o instanceof Task ) {
                            return (Task) o;
                        }
                    }
                    return null;
                })
                .filter(task1 -> task1 != null)
                .map(task -> {
                    if ( task instanceof ListTask ) {
                        return TaskDto.createTaskWithUser((ListTask) task);
                    } else if ( task instanceof NoteTask ) {
                        return TaskDto.createTaskWithUser((NoteTask) task);
                    }
                    return TaskDto.createTaskWithUser(task);
                }).collect(Collectors.toList());
    }

    public List<TaskDto> getTaskDtos(List<Task> tasks) {
        return tasks.stream()
                .map(task -> {
                    if ( task instanceof ListTask ) {
                        return TaskDto.createTaskWithUser((ListTask) task);
                    } else if ( task instanceof NoteTask ) {
                        return TaskDto.createTaskWithUser((NoteTask) task);
                    }
                    return TaskDto.createTaskWithUser(task);
                }).collect(Collectors.toList());
    }

    public List<UserDto> getAdultUser() {
        return userRepositoryCustom.findAdultUsers().stream()
                .map(user -> new UserDto((User) user))
                .collect(Collectors.toList());
    }

    public List<UserTaskDto> getUserTasks() {
        try {
            return userRepositoryCustom.getUserTasks();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
