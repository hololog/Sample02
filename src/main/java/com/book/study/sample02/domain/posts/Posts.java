package com.book.study.sample02.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Posts클래스 : 실제DB의 테이블과 매칭될 클래스
 */
@Getter //모든필드 Getter생성
@NoArgsConstructor //기본생성자 추가
@Entity //테이블과 링크 나타냄(클래스명=테이블명(스네이크케이스))
public class Posts extends BaseTimeEntity {
    
    @Id // 테이블의 pk필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk생성규칙
    private long id;
    
    @Column(length = 500, nullable = false) //컬럼 기본값변경시 사용
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    private String author;

    @Builder //해당클래스의 빌더 패턴클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
