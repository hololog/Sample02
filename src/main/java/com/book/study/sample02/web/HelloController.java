package com.book.study.sample02.web;

import com.book.study.sample02.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Json을 반환하는 컨트롤러로 만드는 어노테이션 (=@ResponseBody)
public class HelloController {

    @GetMapping("/hello") //get요청을 받을수 있도록 하는 어노테이션
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name //get의 매개변수를 넘겨받는 어노테이션
                                    , @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
