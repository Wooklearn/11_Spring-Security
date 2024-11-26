package com.ohgiraffers.sessionsecurity.user.model.service;

import com.ohgiraffers.sessionsecurity.user.model.dao.UserMapper;
import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    @Autowired  // 의존성 주입 - Config에 있는걸 사용하겠다 선언.
    private PasswordEncoder encoder;

    @Autowired
    private UserMapper userMapper;

    @Transactional // DML 구문이기 때문에 붙임
    public int regist(SignupDTO signupDTO) {

        /* comment.
        *   Service 계층은 본격적으로 DB에 값을 넣기 위한
        *   데이터를 가공하는 계층이다
        *   현재 signupDTO 에 userPass 필드는 아직 비밀번호가
        *   암호화가 되어있지 않다. 따라서 DB 에 insert 하기 전
        *   비밀번호를 암호화 할 것이다. */
        // 비밀번호 암호화
        signupDTO.setUserPass(encoder.encode(signupDTO.getUserPass()));

        int result = userMapper.regist(signupDTO);

        return result;

    }
}
