package io.tdd.sys.yeongSu.web;

import io.tdd.sys.yeongSu.dto.UserLoginDto;
import io.tdd.sys.yeongSu.dto.UserRegistDto;
import io.tdd.sys.yeongSu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "")
    public String loginForm(@ModelAttribute("loginForm") UserLoginDto.Request loginForm)  {
        return loginForm.getAccount() == null ? "users/login" : "redirect:/";
    }

    @PostMapping(value = "/session")
    public String session(@ModelAttribute("loginForm") UserLoginDto.Request req,
        BindingResult bindingResult,
        @RequestParam(defaultValue = "/") String redirectURL
    ) {

        if(bindingResult.hasErrors()) {
            return "users/login";
        }

        UserLoginDto.Response user = userService.userLogin(req);

        return "redirect:" + redirectURL;
    }

    @GetMapping(value = "/join/personal")
    public String joinForm(@ModelAttribute("joinForm") UserRegistDto userRegistDto) {
        return "users/join/registPersonal";
    }

    @PostMapping(value = "/join/personal")
    public String join(@ModelAttribute("joinForm") UserRegistDto userRegistDto,
        @RequestParam(defaultValue = "/") String redirectURL ) {
        logger.info(userRegistDto.getUserId());
        logger.info(userRegistDto.getPassword());
        logger.info(userRegistDto.getName());

        userService.joinUser(userRegistDto);

        return "redirect:" + redirectURL;
    }

    @GetMapping(value="/my")
    public String myPage() {
        return "users/my";
    }
}
