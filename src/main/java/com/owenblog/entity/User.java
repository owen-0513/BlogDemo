package com.owenblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by owen on 2023/10/26.
 */
@Entity
@Getter
@Setter
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname",columnDefinition = "VARCHAR(128) COMMENT '暱稱'")
    private String nickname;

    @Column(name = "username",columnDefinition = "VARCHAR(128) COMMENT '帳號名稱'")
    private String username;

    @Column(name = "password",columnDefinition = "VARCHAR(128) COMMENT '密碼'")
    private String password;

    @Column(name = "email",columnDefinition = "VARCHAR(128) COMMENT '信箱'")
    private String email;

    @Column(name = "avatar",columnDefinition = "VARCHAR(128) COMMENT '大頭像'")
    private String avatar;

    @Column(name = "type" ,columnDefinition = "VARCHAR(128) COMMENT 'type'")
    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
