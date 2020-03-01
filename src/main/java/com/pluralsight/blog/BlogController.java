package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public List<Post> listPosts(ModelMap modelMap) {
        // modelMap.put("title", "Blog Post 1");

        List<Post> allPosts = postRepository.getAllPosts();

        modelMap.put("posts", allPosts);
        return allPosts;
    }
}
