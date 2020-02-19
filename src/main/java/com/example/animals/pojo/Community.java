package com.example.animals.pojo;

import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_community")
@ToString
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_community",comment="互动区表")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "adopt_id")
    private Long adoptId;

    private String content;
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 发互动的多个图片
     */
    @Column(name = "img_urls",columnDefinition = "varchar(255) comment '发互动的多个图片'")
    private String imgUrls;

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