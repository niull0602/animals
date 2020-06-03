package com.example.animals.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_community")
@ToString
@Data
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adopt_id")
    private Long adoptId;
//user
    private String content;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 发互动的多个图片
     */
    @Column(name = "img_urls",columnDefinition = "varchar(255) comment '发互动的多个图片'")
    private String imgUrls;
    @Column(name = "user_id",columnDefinition = "bigint comment '用户id'")
    private Long userId;

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
     * @return adopt_id
     */
    public Long getAdoptId() {
        return adoptId;
    }

    /**
     * @param adoptId
     */
    public void setAdoptId(Long adoptId) {
        this.adoptId = adoptId;
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
     * 获取发互动的多个图片
     *
     * @return img_urls - 发互动的多个图片
     */
    public String getImgUrls() {
        return imgUrls;
    }

    /**
     * 设置发互动的多个图片
     *
     * @param imgUrls 发互动的多个图片
     */
    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls == null ? null : imgUrls.trim();
    }
}