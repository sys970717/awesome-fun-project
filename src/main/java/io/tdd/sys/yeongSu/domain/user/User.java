package io.tdd.sys.yeongSu.domain.user;

import io.tdd.sys.yeongSu.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String name;
    private String password;

    public static User ofForCreate(String userId, String name, String password) {
        User instance = new User();

        instance.userId = userId;
        instance.name = name;
        instance.password = password;

        return instance;
    }
}

