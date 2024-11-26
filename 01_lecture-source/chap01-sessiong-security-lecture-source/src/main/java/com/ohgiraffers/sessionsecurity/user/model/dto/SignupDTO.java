package com.ohgiraffers.sessionsecurity.user.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SignupDTO {

    private String userId;
    private String userName;
    private String userPass;
    private String role;

}
