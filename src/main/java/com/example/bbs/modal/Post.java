package com.example.bbs.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  

  private Long id;
  private String title;
  private String content;
  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime updatedAt = LocalDateTime.now();

  @prePersist
  public void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @preUpdate
  public void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}