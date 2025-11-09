package com.example.bbs.controller;

import org.springframework.stereotype.Controller;
import com.example.bbs.service.PostService;
import com.example.bbs.modal.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  //新規投稿画面を表示
  @GetMapping("/new")
  public String newPost(Model model) {
    model.addAttribute("post", new Post());
    return "posts/new";
  }
}
