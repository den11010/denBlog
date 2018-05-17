package blog.controllers;

import blog.models.Post;
import blog.services.INotificationService;
import blog.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  PostController handles URLs like /posts/view/{id}/ and finds
 *  the requested post using the @Autowired implementation of the IPostService
 *  and renders the view “posts/view“, which corresponds to the file “view.html”
 *  in directory src/main/resources/templates/posts.
 * */

@Controller
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private INotificationService notifyService;

    @RequestMapping(value = "/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);

        if(post ==null){  // if the post with passed id doesn't exist, then display error message
            notifyService.addErrorMessage("Guess what... there is no post #" + id);
            return "redirect:/"; // return to the main page
        }

        model.addAttribute("post",post);
        return "posts/view";
    }

}
