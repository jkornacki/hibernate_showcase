package pl.com.agora.kornaja.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.UserGroup;

import java.util.List;

/**
 * Created by P on 2015-11-23.
 */
@Repository
public interface UserCrudRepository extends CrudRepository<User,Long> {

    User findUserByLogin(String login);

    List<User> findUsersByUserGroups(UserGroup userGroup);

    @Query("select user from User user inner join user.userGroups groups where groups.id = :id")
    List<User> findUsersByUserGroups(@Param("id") Long id);

}
