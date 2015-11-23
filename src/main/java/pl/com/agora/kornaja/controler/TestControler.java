package pl.com.agora.kornaja.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.com.agora.kornaja.domain.Permission;

import pl.com.agora.kornaja.domain.UserGroup;
import pl.com.agora.kornaja.repository.UserCrudRepository;
import pl.com.agora.kornaja.repository.UserGroupCrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kornaja.
 */
@Component
public class TestControler implements CommandLineRunner {

    @Autowired
    private UserGroupCrudRepository userGroupCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public void run(String... strings) throws Exception {
        UserGroup userGroup = new UserGroup();
        userGroup.setKey2("Key1");
        userGroup.setName("Grupa 1");

        List<Permission> permissionList = new ArrayList<>();
        permissionList.add(Permission.READ_TASK);
        permissionList.add(Permission.WRITE_TASK);
        userGroup.setPermissions(permissionList);

        userGroupCrudRepository.save(userGroup);
    }
}
