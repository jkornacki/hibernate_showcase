package pl.com.agora.kornaja.controler.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.com.agora.kornaja.domain.Permission;
import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.UserAdress;
import pl.com.agora.kornaja.domain.UserGroup;
import pl.com.agora.kornaja.domain.task.ListTask;
import pl.com.agora.kornaja.domain.task.NoteTask;
import pl.com.agora.kornaja.domain.task.TaskCategory;
import pl.com.agora.kornaja.repository.TaskCategoryCrudRepository;
import pl.com.agora.kornaja.repository.TaskCrudRepository;
import pl.com.agora.kornaja.repository.UserCrudRepository;
import pl.com.agora.kornaja.repository.UserGroupCrudRepository;

import java.util.*;

/**
 * Created by P on 2015-11-23.
 */
@Service
public class LoadData implements CommandLineRunner {

    @Autowired
    private TaskCrudRepository taskCrudRepository;
    @Autowired
    private TaskCategoryCrudRepository taskCategoryCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserGroupCrudRepository userGroupCrudRepository;

    @Override
    public void run(String... strings) throws Exception {
        //User 1
        User user1 = new User();
        user1.setLogin("login_user1");
        user1.setPassword("password");
        UserAdress adress = new UserAdress();
        adress.setCity("1");
        adress.setCountry("1");
        user1.setAdress(adress);

        //User 2
        User user2 = new User();
        user2.setLogin("login_user2");
        user2.setPassword("password");
        UserAdress adress2 = new UserAdress();
        adress2.setCity("2");
        adress2.setCountry("2");
        user2.setAdress(adress2);

        //User 3
        User user3 = new User();
        user3.setLogin("login_user3");
        user3.setPassword("password");
        UserAdress adress3 = new UserAdress();
        adress3.setCity("3");
        adress3.setCountry("3");
        user3.setAdress(adress3);

        userCrudRepository.save(user1);
        userCrudRepository.save(user2);
        userCrudRepository.save(user3);

        List<Permission> permissions = new ArrayList<>();
        permissions.add(Permission.READ);
        permissions.add(Permission.WRITE);
        //User Gropu 1
        UserGroup userGroup1 = new UserGroup();
        userGroup1.setName("user group 1");
        userGroup1.setPermissions(permissions);

        //User Gropu 2
        UserGroup userGroup2 = new UserGroup();
        userGroup2.setName("user group 2");
        userGroup2.setPermissions(permissions);
        userGroupCrudRepository.save(userGroup1);
        userGroupCrudRepository.save(userGroup2);


        //Przypisanie User do user group
        List<UserGroup> groups = new ArrayList<>();
        groups.add(userGroup1);
        user1.setUserGroups(groups);
        userCrudRepository.save(user1);

        List<UserGroup> groups2 = new ArrayList<>();
        groups2.add(userGroup2);
        user2.setUserGroups(groups2);
        userCrudRepository.save(user2);

        List<UserGroup> groups3 = new ArrayList<>();
        groups3.add(userGroup2);
        user3.setUserGroups(groups2);
        userCrudRepository.save(user3);


        //Task kategory
        TaskCategory taskCategory = new TaskCategory();
        taskCategory.setName("Task Category");
        taskCategoryCrudRepository.save(taskCategory);

        //Task 1
        ListTask listTask1 = new ListTask();
        listTask1.setTitle("List task 1");
        listTask1.setCreateDate(new Date());
        List<String> listTask1Tags = new ArrayList<>();
        listTask1Tags.add("list");
        listTask1Tags.add("list1");
        listTask1.setTags(listTask1Tags);
        Map<String ,Boolean> listTask1Subtasks = new HashMap<>();
        listTask1Subtasks.put("Task 1",false);
        listTask1Subtasks.put("Task 2",false);
        listTask1Subtasks.put("Task 3",false);
        listTask1.setSubtask(listTask1Subtasks);
        listTask1.setUser(user1);
        listTask1.setTaskCategory(taskCategory);
        taskCrudRepository.save(listTask1);

        //Task 2
        NoteTask noteTask1 = new NoteTask();
        noteTask1.setTitle("note task");
        noteTask1.setCreateDate(new Date());
        List<String> noteTask1Tags = new ArrayList<>();
        noteTask1Tags.add("Note");
        noteTask1Tags.add("Note task 1");
        noteTask1.setContent("C O N T E N T  C O N T E N T  C O N T E N T");
        noteTask1.setUser(user2);
        noteTask1.setTaskCategory(taskCategory);
        noteTask1.setTags(noteTask1Tags);
        taskCrudRepository.save(noteTask1);
    }
}
