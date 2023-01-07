package com.book.study.sample02.web;

import com.book.study.sample02.service.posts.PostsService;
import com.book.study.sample02.web.dto.PostsResponseDto;
import com.book.study.sample02.web.dto.PostsSaveRequestDto;
import com.book.study.sample02.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //생성자를 통한 DI(추천)
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /**
     * 게시글 저장
     * @param requestDto
     * @return id 기본키
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){ //요청본문을 자바객체로 변환
        return postsService.save(requestDto);
    }

    /**
     * 게시글 수정
     * @param id 기본키
     * @param requestDto 게시글
     * @return id
     */
    @PostMapping("/api/v1/posts/{id}") //
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    /**
     * 게시글 조회
     * @param id
     * @return responseDto 게시글
     */
    @GetMapping("/api/v1/posts/{id}") //
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

}
