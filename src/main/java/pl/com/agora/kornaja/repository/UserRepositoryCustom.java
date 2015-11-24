package pl.com.agora.kornaja.repository;

import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.task.Task;
import pl.com.agora.kornaja.dto.UserTaskDto;

import java.util.List;

/**
 * Created by P on 2015-11-24.
 */
public interface UserRepositoryCustom {

    List<Task> findUserTasks(Long userId);

    List<Object> findUserAndTasks(Long userId);

    List<User> findAdultUsers();

    List<Task> findTaskAdultUsers();

    List<UserTaskDto> getUserTasks() throws NoSuchMethodException;
}
