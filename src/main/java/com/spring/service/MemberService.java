package com.spring.service;

import com.spring.model.MemberDTO;

import java.util.List;

public interface MemberService {
    MemberDTO readOne(String email, String password);


    MemberDTO save(MemberDTO memberDTO);


    MemberDTO update(MemberDTO memberDTO);
}
