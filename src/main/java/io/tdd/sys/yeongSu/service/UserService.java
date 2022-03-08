package io.tdd.sys.yeongSu.service;

import io.tdd.sys.yeongSu.domain.user.User;
import io.tdd.sys.yeongSu.dto.UserLoginDto;
import io.tdd.sys.yeongSu.dto.UserRegistDto;

public interface UserService {
    UserLoginDto.Response userLogin(UserLoginDto.Request user);
    User joinUser(UserRegistDto userRegistDto);
}
