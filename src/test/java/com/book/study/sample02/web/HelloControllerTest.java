package com.book.study.sample02.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //내장실행자외 다른 실행자 실행=junit과 스프링부트 연결
@WebMvcTest(controllers = HelloController.class) //스프링데스트어노테이션
public class HelloControllerTest {

        @Autowired // 스피링이 관리하는 Bean주입
        private MockMvc mvc; //get,post 테스트 시작점

        @Test
        public void hello가_리턴된다() throws Exception {
            String hello = "hello";

            mvc.perform(get("/hello"))
                    .andExpect(status().isOk()) //응답헤더 검증 200,404,500
                    .andExpect(content().string(hello)); //응답본문 검증 (내용검증)
        }

        @Test
        public void helloDto가_리턴된다() throws Exception{
            String name = "test";
            int amount = 1000;

            mvc.perform(get("/hello/dto")
                    .param("name", name) //테스트할 요청 파라미터 설정(string만 가능)
                    .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));//json응답값 검증메소드
        }
}
