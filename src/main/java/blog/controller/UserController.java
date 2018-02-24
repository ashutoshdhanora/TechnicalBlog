package blog.controller;

import blog.model.User;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/users/login")
    public String loginPage(User user) {

        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String login(User user, Model model) {

        if (userService.authenticate(user.getUsername(), user.getPasswordHash())) {
            return "redirect:/posts";
        }
        return "redirect:/";
    }

}
