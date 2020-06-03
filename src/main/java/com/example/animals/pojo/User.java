package com.example.animals.pojo;

import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number",unique = true,columnDefinition = "bigint comment '手机号码/账号'")
    private Long phoneNumber;
    @Column(name = "password",length = 40)
    private String password;

    @Column(name = "nick_name",length = 20)
    private String nickName;

    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 真实姓名
     */
    @Column(name = "name",length = 10,columnDefinition = "varchar(10) comment '真实姓名'")
    private String name;

    private Integer age;
    @Column(name = "sex",length = 4)
    private String sex;
    @Column(name = "address",length = 50,columnDefinition = "varchar(50) comment '家庭地址/收货地址'")
    private String address;

    /**
     * 余额
     */
    @Column(columnDefinition = "double comment '余额'")
    private Double money;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户-0 管理员-1
     */
    @Column(columnDefinition = "smallint comment '用户-0 管理员-1'")
    private Short mark;

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
     * @return phone_number
     */
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取余额
     *
     * @return money - 余额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置余额
     *
     * @param money 余额
     */
    public void setMoney(Double money) {
        this.money = money;
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
     * 获取用户-0 管理员-1
     *
     * @return mark - 用户-0 管理员-1
     */
    public Short getMark() {
        return mark;
    }

    /**
     * 设置用户-0 管理员-1
     *
     * @param mark 用户-0 管理员-1
     */
    public void setMark(Short mark) {
        this.mark = mark;
    }
}