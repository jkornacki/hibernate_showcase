package pl.com.agora.kornaja.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.springframework.stereotype.Repository;
import pl.com.agora.kornaja.domain.User;
import pl.com.agora.kornaja.domain.task.Task;
import pl.com.agora.kornaja.dto.UserTaskDto;
import pl.com.agora.kornaja.repository.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Constructor;
import java.util.List;

/**
 * Created by P on 2015-11-24.
 */
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(org.hibernate.Session.class);
    }

    @Override
    public List<Object> findUserAndTasks(Long userId) {
        String SQL = "FROM " + Task.class.getName() + " task " +
                "INNER JOIN task.user user " +
                "WHERE user.id = :userId";
        org.hibernate.Query query = getSession().createQuery(SQL);
        query.setParameter("userId", userId);
        return query.list();
    }

    @Override
    public List<Task> findUserTasks(Long userId) {
        String SQL = "SELECT task " +
                "FROM " + Task.class.getName() + " task " +
                "INNER JOIN task.user user " +
                "WHERE user.id = :userId";
        org.hibernate.Query query = getSession().createQuery(SQL);
        query.setParameter("userId", userId);
        return query.list();
    }

    @Override
    public List<User> findAdultUsers() {
        Criteria criteria = getSession().createCriteria(User.class, "user");
        criteria.add(Restrictions.ge("user.age", 18));
        return criteria.list();
    }

    @Override
    public List<Task> findTaskAdultUsers() {
        Criteria criteria = getSession().createCriteria(Task.class, "task");

        DetachedCriteria adultUserCriteria = DetachedCriteria.forClass(User.class, "user");
        adultUserCriteria.setProjection(Property.forName("id"));
        adultUserCriteria.add(Restrictions.ge("user.age", 18));

        criteria.add(Subqueries.propertyIn("task.user", adultUserCriteria));

        return criteria.list();
    }

    @Override
    public List<UserTaskDto> getUserTasks() throws NoSuchMethodException {
        Constructor<UserTaskDto> constructor = UserTaskDto.class.getConstructor(Long.class, Long.class, String.class, String.class);

        Criteria criteria = getSession().createCriteria(Task.class, "task")
                .createAlias("task.user", "user");
        Projection projection = Projections.projectionList()
                .add(Projections.property("user.id"))
                .add(Projections.property("task.id"))
                .add(Projections.property("user.login"))
                .add(Projections.property("task.title"));
        criteria.setProjection(projection);
        criteria.setResultTransformer(new AliasToBeanConstructorResultTransformer(constructor));
        return criteria.list();
    }
}

