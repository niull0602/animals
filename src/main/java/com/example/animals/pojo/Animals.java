package com.example.animals.pojo;

import javax.persistence.*;

@Table(name = "t_animals")
public class Animals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "animal_name")
    private String animalName;

    /**
     * 展示图
     */
    @Column(name = "animal_img")
    private String animalImg;

    /**
     * 详情图（多个）
     */
    @Column(name = "animal_imgs")
    private String animalImgs;

    @Column(name = "animal_color")
    private String animalColor;

    @Column(name = "animal_sex")
    private String animalSex;

    /**
     * 详情
     */
    @Column(name = "aninal_desc")
    private String aninalDesc;

    /**
     * 领养状态  0：待领养  1：领养 
     */
    private Integer status;

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