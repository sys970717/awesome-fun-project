package io.tdd.sys.yeongSu.domain.repository.impl;

import io.tdd.sys.yeongSu.domain.user.User;
import io.tdd.sys.yeongSu.domain.repository.UserRepositoryCustom;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    EntityManager em;

    UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<User> findByNameAndPassword(String name, String password) {
        TypedQuery<User> userQuery = this.em.createQuery("SELECT u FROM User as u where u.name = :name", User.class)
                .setParameter("name", name);
        return userQuery.getResultList().stream().filter(v -> v.getPassword().equals(password)).findAny();
    }

    @Override
    public Optional<User> findByUserIdAndPassword(String userId, String password) {
        TypedQuery<User> userQuery = this.em.createQuery("SELECT u FROM User as u where u.userId = :userId", User.class)
            .setParameter("userId", userId);

        return userQuery.getResultList().stream().filter(v -> v.getPassword().equals(password)).findAny();
    }

}
