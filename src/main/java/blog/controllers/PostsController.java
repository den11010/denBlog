package blog.controllers;

import blog.models.Post;
import blog.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostsController {

    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/posts/index")
    public String postsPage(Model model){

        List<Post> allPosts = postService.findAll();

        model.addAttribute("allPosts",allPosts);

        return "/posts/index";
    }
}
