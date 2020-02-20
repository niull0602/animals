package com.example.animals.pojo;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Table(name = "t_animals")
@ToString
@Data
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_animals",comment="动物实体表")
public class Animals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "animal_name",length = 20)
    private String animalName;

    /**
     * 展示图
     */
    @Column(name = "animal_img",columnDefinition = "varchar(255) comment '展示图'")
    private String animalImg;

    /**
     * 详情图（多个）
     */
    @Column(name = "animal_imgs",columnDefinition = "varchar(255) comment '详情图（多个）'")
    private String animalImgs;

    @Column(name = "animal_color",length = 50)
    private String animalColor;

    @Column(name = "animal_sex",length = 10)
    private String animalSex;

    /**
     * 详细介绍
     */
    @Column(name = "aninal_desc",columnDefinition = "varchar(255) comment '详细介绍'")
    private String aninalDesc;

    /**
     * 领养状态  0：待领养  1：领养 
     */
    @Column(name = "status",columnDefinition = "int comment '领养状态  0：待领养  1：领养 '")
    private Integer status;

    @CreationTimestamp
    @Column(name = "regist_time",columnDefinition = "datetime comment '登记时间'")
    private Date regist_time;

    @Column(name = "type_id")
    private Long typeId;

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
     * @return animal_name
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * @param animalName
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName == null ? null : animalName.trim();
    }

    /**
     * 获取展示图
     *
     * @return animal_img - 展示图
     */
    public String getAnimalImg() {
        return animalImg;
    }

    /**
     * 设置展示图
     *
     * @param animalImg 展示图
     */
    public void setAnimalImg(String animalImg) {
        this.animalImg = animalImg == null ? null : animalImg.trim();
    }

    /**
     * 获取详情图（多个）
     *
     * @return animal_imgs - 详情图（多个）
     */
    public String getAnimalImgs() {
        return animalImgs;
    }

    /**
     * 设置详情图（多个）
     *
     * @param animalImgs 详情图（多个）
     */
    public void setAnimalImgs(String animalImgs) {
        this.animalImgs = animalImgs == null ? null : animalImgs.trim();
    }

    /**
     * @return animal_color
     */
    public String getAnimalColor() {
        return animalColor;
    }

    /**
     * @param animalColor
     */
    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor == null ? null : animalColor.trim();
    }

    /**
     * @return animal_sex
     */
    public String getAnimalSex() {
        return animalSex;
    }

    /**
     * @param animalSex
     */
    public void setAnimalSex(String animalSex) {
        this.animalSex = animalSex == null ? null : animalSex.trim();
    }

    /**
     * 获取详情
     *
     * @return aninal_desc - 详情
     */
    public String getAninalDesc() {
        return aninalDesc;
    }

    /**
     * 设置详情
     *
     * @param aninalDesc 详情
     */
    public void setAninalDesc(String aninalDesc) {
        this.aninalDesc = aninalDesc == null ? null : aninalDesc.trim();
    }

    /**
     * 获取领养状态  0：待领养  1：领养 
     *
     * @return status - 领养状态  0：待领养  1：领养 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置领养状态  0：待领养  1：领养 
     *
     * @param status 领养状态  0：待领养  1：领养 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return type_id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}