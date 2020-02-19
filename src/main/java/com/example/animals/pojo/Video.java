package com.example.animals.pojo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "t_video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 发视频地址
     */
    @Column(name = "address",length = 100,columnDefinition = "varchar(100) comment '发视频地址'")
    private String address;

    /**
     * 0：待救助  1：自养  
     */
    @Column(name = "adopt_status",columnDefinition = "int comment '0：待救助  1：自养  '")
    private Integer adoptStatus;
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

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
     * @return video_url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 获取发视频地址
     *
     * @return address - 发视频地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置发视频地址
     *
     * @param address 发视频地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取0：待救助  1：自养  
     *
     * @return adopt_status - 0：待救助  1：自养  
     */
    public Integer getAdoptStatus() {
        return adoptStatus;
    }

    /**
     * 设置0：待救助  1：自养  
     *
     * @param adoptStatus 0：待救助  1：自养  
     */
    public void setAdoptStatus(Integer adoptStatus) {
        this.adoptStatus = adoptStatus;
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
}