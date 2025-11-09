package com.example.bbs.service;

import org.springframework.stereotype.Service;
import com.example.bbs.modal.Post;
import com.example.bbs.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }
}