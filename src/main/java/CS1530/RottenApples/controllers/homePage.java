package CS1530.RottenApples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homePage {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "UserLogin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
