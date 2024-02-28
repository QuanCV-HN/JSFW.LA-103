package com.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Title",nullable = false)
    private String title;
    @Column(name = "Brief",nullable = false)
    private String brief;
    @Column(name = "Content",nullable = false)
    private String content;

    @Column(name = "CreateDate", columnDefinition = "")
    private Date createDate;
    @Column(name = "UpdateTime")
    private Date updateTime;
    @Column(name = "AuthorID",nullable = false)
    private Integer authorId;

    @ManyToOne
    @JoinColumn
    private Member member;

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", updateTime=" + updateTime +
                ", authorId=" + authorId +
                '}';
    }
}
