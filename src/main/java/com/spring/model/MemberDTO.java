package com.spring.model;


import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Integer id;

    private String email;

    private String password;

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String description;

    private Date createdDate;

    private Date updateTime;


}
