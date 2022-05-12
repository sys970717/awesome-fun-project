package io.tdd.sys.yeongSu.web;

import io.tdd.sys.yeongSu.config.SessionConstants;
import io.tdd.sys.yeongSu.domain.user.User;
import io.tdd.sys.yeongSu.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    @GetMapping(value="/")
    public String main (@SessionAttribute(name = SessionConstants.LOGIN_USER, required = false) UserLoginDto.Response user, Model model) {
        model.addAttribute("user", user);
        return "main/index.html";
    }
}
