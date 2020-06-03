package com.example.animals.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_second_comments")
@Data
public class SecondComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_uid")
    private Long fromUserId;

    @Column(name = "to_uid")
    private Long toUserId;

    @Column(name = "content",length = 100)
    private String content;
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