package com.book.study.sample02.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { //<entity클래스, pk타입>

}
