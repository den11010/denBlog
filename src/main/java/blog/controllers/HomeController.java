package blog.controllers;

import blog.models.Post;
import blog.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controllers hold the presentation (UI) logic – process user request (GET / POST / other),
 * prepare data for the view and render the view (or redirect to another URL).
 * Example: prepare and show the home page.
* */


@Controller
public class HomeController {

    @Autowired //It automatically injects the correct implementation for services at the places where they are needed
    private IPostService postService;

    @RequestMapping(value = "/")
    public String index (Model model){

        List<Post> latestFivePosts = postService.findLatestFive();
        model.addAttribute("latestFivePosts",latestFivePosts);

        List<Post> latestThreePosts = latestFivePosts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latestThreePosts",latestThreePosts);

        return "index";  //returns the “index” view and this means to render a Thymeleaf template “index.html”
    }
}
