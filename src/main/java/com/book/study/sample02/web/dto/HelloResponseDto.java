package com.book.study.sample02.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 필드(변수)의 get메서드 생성
@RequiredArgsConstructor // 선언된 final 필드(변수)의 생성자 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
