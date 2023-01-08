package com.book.study.sample02.service.posts;

import com.book.study.sample02.domain.posts.Posts;
import com.book.study.sample02.domain.posts.PostsRepository;
import com.book.study.sample02.web.dto.PostsResponseDto;
import com.book.study.sample02.web.dto.PostsSaveRequestDto;
import com.book.study.sample02.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //final인 필드를 파라미터로 하는 생성자 생성
@Service
public class PostsService {

    public final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        //기본키로 게시글 조회
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다.id="+id));
        //조회글 수정 => 쿼리를 날리지 않음(entity객체의 값만 변경되면 DB도 자동 변경됨)
        posts.update(requestDto.getTitle(), requestDto.getContent());
        
        return id;
    }

    public PostsResponseDto findById(Long id) {
        //기본키로 게시골 조회
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다.id="+id));
        //
        return new PostsResponseDto(entity);
    }
}
