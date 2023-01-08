package com.book.study.sample02.web;

import com.book.study.sample02.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){//model 객체저장
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; //templates폴더의 index파일
    }

    @GetMapping("/posts/save")
    public String PostsSave(){
        return "posts-save";
    }
}
