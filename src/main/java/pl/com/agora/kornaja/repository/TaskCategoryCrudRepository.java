package pl.com.agora.kornaja.repository;

import org.springframework.data.repository.CrudRepository;
import pl.com.agora.kornaja.domain.task.TaskCategory;

/**
 * Created by P on 2015-11-23.
 */
public interface TaskCategoryCrudRepository extends CrudRepository<TaskCategory,Long> {
}
