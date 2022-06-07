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
public class HomeController {
    @GetMapping(value="/")
    public String home (@SessionAttribute(name = SessionConstants.LOGIN_USER, required = false) UserLoginDto.Response user, Model model) {
        // 세션에 회원 데이터가 없으면 홈으로 이동
        if (user == null) {
            return "main/index.html";
        }

        // 세션이 유지되면 로그인 홈으로 이동
        model.addAttribute("member", user);

        return "main/loginHome";
    }

    @GetMapping("/test")
    public ModelAndView fragmentHome (ModelAndView modelAndView, @SessionAttribute(name = SessionConstants.LOGIN_USER, required = false) UserLoginDto.Response user) {
        // 세션이 유지되면 로그인 홈으로 이동
        modelAndView.addObject("member", user);
        modelAndView.setViewName("fragments/layout/defaultLayout.html");
        return modelAndView;
    }
}

