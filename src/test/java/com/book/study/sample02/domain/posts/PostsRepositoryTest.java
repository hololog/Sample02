package com.book.study.sample02.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //
public class PostsRepositoryTest {
    
    @Autowired //의존성 주입
    PostsRepository postsRepository;
    
    @After //단위테스트 종료후 실행(테스트용 db초기화)
    public void cleanup(){
        postsRepository.deleteAll();
    }
    
    @Test
    public void 게시물저장_불러오기(){
        //전제조건
        String title = "Test게시글";
        String content = "Test 본문"; 

        //테이블에 insert
        postsRepository.save(Posts.builder() //setter대신 빌더패턴 이용(값을 더 정확하게 입력)
                .title(title)
                .content(content)
                .author("test저자")
                .build());
        
        //when
        List<Posts> postsList = postsRepository.findAll(); //테이블 조회
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        //시간
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>> createDate=" +posts.getCreateDate()
                + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
