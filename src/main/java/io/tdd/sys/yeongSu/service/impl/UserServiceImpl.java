package io.tdd.sys.yeongSu.service.impl;

import io.tdd.sys.yeongSu.domain.repository.UserRepository;
import io.tdd.sys.yeongSu.domain.user.User;
import io.tdd.sys.yeongSu.dto.UserLoginDto;
import io.tdd.sys.yeongSu.dto.UserRegistDto;
import io.tdd.sys.yeongSu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserLoginDto.Response userLogin(UserLoginDto.Request user) {
        logger.info("Hi Service");
        logger.info("Account = "+ user.getAccount());

        User userEntity = userRepository.findByUserIdAndPassword(user.getAccount(), user.getPassword()).orElseThrow();

        return UserLoginDto.Response.of(userEntity.getUserId(), userEntity.getName());
    }

    @Override
    public User joinUser(UserRegistDto userRegistDto) {
        User user = User.ofForCreate(userRegistDto.getUserId(), userRegistDto.getName(), userRegistDto.getPassword());

        return userRepository.save(user);
    }
}
