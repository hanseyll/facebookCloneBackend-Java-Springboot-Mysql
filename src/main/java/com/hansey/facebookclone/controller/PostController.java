package com.hansey.facebookclone.controller;

import com.hansey.facebookclone.model.Post;
import com.hansey.facebookclone.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post addPost(@RequestParam Map<String,String> requestParams){
        String strpost = requestParams.get("post");
        String email = requestParams.get("email");
        String name = requestParams.get("name");
        String file = requestParams.get("file");
        String profilePic = requestParams.get("profilePic");

        Post post = Post.builder()
                .file(file)
                .name(name)
                .email(email)
                .post(strpost)
                .profilePic(profilePic)
                .timeStamp(new Date().toString())
                .build();

        post = postService.addPost(post);
        return post;
    }
}
