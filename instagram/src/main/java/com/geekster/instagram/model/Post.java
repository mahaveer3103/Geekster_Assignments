package com.geekster.instagram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_tbl")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "updated_date")
    private Timestamp updateDate;
    @Column(name = "post_data")
    private String postData;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)  //Many Post for One User
    private User user;

}
