package io.tdd.sys.yeongSu.web;

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
    public void session(@RequestBody String name,
        @RequestBody String password) {
        System.out.println(name);
    }

}
