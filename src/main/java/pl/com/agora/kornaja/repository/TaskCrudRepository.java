package pl.com.agora.kornaja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.agora.kornaja.domain.task.Task;

/**
 * Created by P on 2015-11-23.
 */
@Repository
public interface TaskCrudRepository extends CrudRepository<Task,Long>{
}
