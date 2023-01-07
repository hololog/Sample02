package com.book.study.sample02.web.dto;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //테스트예시값
        String name = "test";
        int amount = 1000;

        //when => 인스턴스생성시
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then 결과= getter결과값
        assertThat(dto.getName()).isEqualTo(name); // assertj 테스트검증 라이브러리
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
