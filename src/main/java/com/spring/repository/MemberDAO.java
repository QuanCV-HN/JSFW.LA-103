package com.spring.repository;

import com.spring.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MemberDAO extends JpaRepository<Member,Integer> {

    @Query(value = "SELECT m from Member m where m.email = ?1  and m.password = ?2")
    Member readOne(String email,String password);

    @Query(value = "SELECT m from Member m where m.username = ?1  or m.email = ?2")
    List<Member> readOneRe(String username, String email);



}
