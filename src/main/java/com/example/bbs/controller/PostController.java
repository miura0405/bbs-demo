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

  // 投稿一覧画面
  @GetMapping
  public String listPosts(Model model) {
    model.addAttribute("posts", postService.findAll());
    return "posts/list";
  }

  // 投稿詳細画面
  @GetMapping("/{id}")
  public String showPost(@PathVariable Long id, Model model) {
    model.addAttribute("post", postService.findById(id).orElseThrow());
    return "posts/detail";
  }

  // 新規投稿フォーム
  @GetMapping("/new")
  public String newPost(Model model) {
    model.addAttribute("post", new Post());
    return "posts/new";
  }

  // 投稿編集フォーム
  @GetMapping("/{id}/edit")
  public String editPostForm(@PathVariable Long id, Model model) {
    model.addAttribute("post", postService.findById(id).orElseThrow());
    return "posts/edit";
  }

  // 投稿編集を更新
  @PostMapping("/{id}/edit")
  public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
    Post existingPost = postService.findById(id).orElseThrow();
    existingPost.setTitle(post.getTitle());
    existingPost.setContent(post.getContent());
    postService.save(existingPost);
    return "redirect:/posts";
    }


  // 新規投稿を作成
  @PostMapping
  public String createPost(@ModelAttribute Post post) {
    postService.save(post);
    return "redirect:/posts";
  }


  // 投稿を削除
  @PostMapping("/{id}/delete")
  public String deletePost(@PathVariable Long id) {
    postService.deleteById(id);
    return "redirect:/posts";
  }
}