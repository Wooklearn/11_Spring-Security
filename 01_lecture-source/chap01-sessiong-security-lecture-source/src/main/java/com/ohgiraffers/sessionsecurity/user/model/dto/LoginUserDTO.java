package com.ohgiraffers.sessionsecurity.user.model.dto;

import com.ohgiraffers.sessionsecurity.common.UserRole;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginUserDTO {

    /* comment.
    *   로그인 시 사용할 DTO 클래스는
    *   화면 상에서 입력 받는 ID, PASSWORD, 뿐만 아니라
    *   로그인에 성공 했을 시 필요한 정보들을 추가적으로 담는다.
    *  */

    private int userCode;
    private String userId;
    private String userName;
    private String password;
    private UserRole userRole;

}
