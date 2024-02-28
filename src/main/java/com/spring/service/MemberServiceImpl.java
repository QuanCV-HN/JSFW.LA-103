package com.spring.service;

import com.spring.entities.Member;
import com.spring.model.MemberDTO;
import com.spring.repository.MemberDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDAO memberDAO;
    @Override
    public MemberDTO readOne(String email, String password) {
        MemberDTO memberDTO = new MemberDTO();
        Member member  =  memberDAO.readOne(email,password);

        if (member == null){
            return null;
        }

        memberDTO.setId(member.getId());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setUsername(member.getUsername());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setPhone(member.getPhone());
        memberDTO.setDescription(member.getDescription());

        return memberDTO;
    }

    @Override
    public MemberDTO save(MemberDTO memberDTO) {
        Member member = new Member();

        member.setId(memberDTO.getId());
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setUsername(memberDTO.getUsername());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setPhone(memberDTO.getPhone());
        member.setDescription(memberDTO.getDescription());
        member.setCreatedDate(new Date());

        memberDAO.save(member);
        return memberDTO;
    }

    @Override
    public MemberDTO update(MemberDTO memberDTO) {
    Optional<Member> optionalMember = memberDAO.findById(memberDTO.getId());
        optionalMember.get().setFirstName(memberDTO.getFirstName());
        optionalMember.get().setLastName(memberDTO.getLastName());
        optionalMember.get().setPhone(memberDTO.getPhone());
        optionalMember.get().setDescription(memberDTO.getDescription());

        optionalMember.get().setUpdateTime(new Date());

        memberDAO.save(optionalMember.get());

        return memberDTO;
    }


}
