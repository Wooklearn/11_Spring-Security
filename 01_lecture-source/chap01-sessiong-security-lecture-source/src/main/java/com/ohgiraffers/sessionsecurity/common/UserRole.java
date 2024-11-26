package com.ohgiraffers.sessionsecurity.common;

import lombok.Getter;

@Getter     // 상수는 값이 변하면 안되므로 GETTER 만 사용
public enum UserRole {

    /* comment.
    *   enum 이란?
    *   열거형 상수들의 집합을 의미한다.
    *   주로 사용되고 있는 예시로는
    *   고정되어있는 값들을 처리하기 위해 사용된다.
    *   EX) 시스템의 권한이 단 2개 - 일반사용자, 관리자
    *  */
    USER("USER"), ADMIN("ADMIN");   // 상수 필드

    private String role;

    UserRole(String role) {this.role = role;}

}