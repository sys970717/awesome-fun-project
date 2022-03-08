package io.tdd.sys.yeongSu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class UserRegistDto {
    private String userId;
    private String password;
    private String name;
    private String email;
}
