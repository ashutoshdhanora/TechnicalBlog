package blog.controller;

import blog.model.Post;
import blog.services.MockPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MockPostServiceImpl postService;

    @RequestMapping("/")
    public String index(Model model) {

        List<Post> postList = postService.findFirstThreePosts();
        model.addAttribute("posts",postList);
        return "index";
    }
}
