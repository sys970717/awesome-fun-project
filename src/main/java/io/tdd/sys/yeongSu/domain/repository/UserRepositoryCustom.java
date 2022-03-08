package io.tdd.sys.yeongSu.domain.repository;

import io.tdd.sys.yeongSu.domain.user.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findByNameAndPassword(String name, String password);
    Optional<User> findByUserIdAndPassword(String userId, String password);
}
