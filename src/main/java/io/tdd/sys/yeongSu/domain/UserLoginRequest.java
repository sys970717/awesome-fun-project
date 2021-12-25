package io.tdd.sys.yeongSu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(staticName = "of")
public class UserLoginRequest {
    private String account;
    private String password;
}
