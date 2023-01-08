package com.book.study.sample02.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> { //<entity클래스, pk타입>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //sprigDataJpa에서 제공하지 않는 쿼리는 작성가능
    List<Posts> findAllDesc();
}
