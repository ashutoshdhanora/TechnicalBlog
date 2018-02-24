package blog.controller;

import blog.forms.RegisterNewUser;
import blog.model.User;
import blog.services.UserService;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.StandardCharsets;

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

    @RequestMapping("/users/register")
    public String register(RegisterNewUser registerNewUser) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String loginPage(RegisterNewUser registerNewUser) {

        User user = new User();
        user.setUsername(registerNewUser.getUsername());
        user.setFullName(registerNewUser.getFullName());

        String sha256hex = Hashing.sha256()
                .hashString(registerNewUser.getPassword())
                .toString();
        user.setPasswordHash(sha256hex);
        userService.registerNewUser(user);
        return "redirect:/";
    }
}
