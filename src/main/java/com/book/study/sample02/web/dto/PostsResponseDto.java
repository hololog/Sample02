package com.book.study.sample02.web.dto;

import com.book.study.sample02.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsResponseDto {
    private String title;
    private String content;
    private String author;
    private Long id;

    //응답담아오기
    public PostsResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.id = entity.getId();
    }
}
