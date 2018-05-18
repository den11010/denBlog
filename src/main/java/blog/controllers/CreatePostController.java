package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreatePostController {
    @RequestMapping(value = "/posts/create")
    public String create (){
        // TODO gotta get me that database knowledge
        return "/posts/create";
    }
}
