package com.example.animals.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_adopt")
public class Adopt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "animal_id")
    private Long animalId;

    /**
     * 领养日期
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "eva_num")
    private Integer evaNum;

    /**
     * 领养状态 0：正常 1：拒绝再次领养
     */
    private Integer status;

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
     * @return animal_id
     */
    public Long getAnimalId() {
        return animalId;
    }

    /**
     * @param animalId
     */
    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    /**
     * 获取领养日期
     *
     * @return create_time - 领养日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置领养日期
     *
     * @param createTime 领养日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return eva_num
     */
    public Integer getEvaNum() {
        return evaNum;
    }

    /**
     * @param evaNum
     */
    public void setEvaNum(Integer evaNum) {
        this.evaNum = evaNum;
    }

    /**
     * 获取领养状态 0：正常 1：拒绝再次领养
     *
     * @return status - 领养状态 0：正常 1：拒绝再次领养
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置领养状态 0：正常 1：拒绝再次领养
     *
     * @param status 领养状态 0：正常 1：拒绝再次领养
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}