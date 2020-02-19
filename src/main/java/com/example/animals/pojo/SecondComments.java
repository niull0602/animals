package com.example.animals.pojo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "t_second_comments")
public class SecondComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "content",length = 100)
    private String content;
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "one_comment_id")
    private Long oneCommentId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return one_comment_id
     */
    public Long getOneCommentId() {
        return oneCommentId;
    }

    /**
     * @param oneCommentId
     */
    public void setOneCommentId(Long oneCommentId) {
        this.oneCommentId = oneCommentId;
    }
}