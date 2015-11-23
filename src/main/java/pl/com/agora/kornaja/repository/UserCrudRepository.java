package pl.com.agora.kornaja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.UserGroup;

/**
 * Created by kornaja.
 */
@Repository
public interface UserCrudRepository extends CrudRepository<User,Long> {
}
