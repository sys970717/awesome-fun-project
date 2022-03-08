package io.tdd.sys.yeongSu.dto;

import lombok.*;

public class UserLoginDto {
    @Getter
    @Setter
    @AllArgsConstructor(staticName = "of")
    public static class Request {
        private String account;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor(staticName = "of")
    public static class Response {
        private String account;
        private String name;
    }

}
