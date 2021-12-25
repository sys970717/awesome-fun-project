package io.tdd.sys.yeongSu.web;

import io.tdd.sys.yeongSu.domain.UserLoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "")
    public String session(String userId)  {
        return userId == null ? "users/login" : "redirect:/";
    }

    @PostMapping(value = "/session")
    public void session(@RequestBody UserLoginRequest users) {
        System.out.println(users.getAccount());
        System.out.println(users.getPassword());
    }
}
