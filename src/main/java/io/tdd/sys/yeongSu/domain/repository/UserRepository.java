package io.tdd.sys.yeongSu.domain.repository;

import io.tdd.sys.yeongSu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
