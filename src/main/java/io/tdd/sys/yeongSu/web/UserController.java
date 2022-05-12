package io.tdd.sys.yeongSu.web;

import io.tdd.sys.yeongSu.config.SessionConstants;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        HttpServletRequest request,
        @RequestParam(defaultValue = "/") String redirectURL
    ) {

        if(bindingResult.hasErrors()) {
            return "users/login";
        }

        UserLoginDto.Response user = userService.userLogin(req);
        if(user == null) {
            bindingResult.reject("loginFail", "아이디 혹은 암호가 일치하지 않습니다.");
            return "users/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_USER, user);

        return "redirect:" + redirectURL;
    }

    @GetMapping(value = "/join/personal")
    public String joinForm(@ModelAttribute("joinForm") UserRegistDto userRegistDto) {
        return "users/join/registPersonal";
    }

    @PostMapping(value = "/join/personal")
    public String join(@ModelAttribute("joinForm") UserRegistDto userRegistDto,
        @RequestParam(defaultValue = "/") String redirectURL) {
        userService.joinUser(userRegistDto);

        return "redirect:" + "/user" + redirectURL;
    }

    @GetMapping(value="/my")
    public String myPage() {
        return "users/my";
    }
}
