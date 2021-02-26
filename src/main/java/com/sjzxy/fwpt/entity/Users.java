package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "users")
@Entity
@Table(name = "users")
@Data
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "用户id" )
    private Integer id;

    @Column(name = "sno" )
    @ApiModelProperty(value = "学号" )
    private String sno;

    @Column(name = "name" )
    @ApiModelProperty(value = "姓名" )
    private String name;

    @Column(name = "password" )
    @ApiModelProperty(value = "密码" )
    private String password;

    @Column(name = "nick" )
    @ApiModelProperty(value = "昵称" )
    private String nick;

    @Column(name = "sex" )
    @ApiModelProperty(value = "性别" )
    private Integer sex;

    @Column(name = "birthday" )
    @ApiModelProperty(value = "出生日期" )
    private Date birthday;

    @Column(name = "photo_address" )
    @ApiModelProperty(value = "头像地址" )
    private String photoAddress;

    @Column(name = "grade" )
    @ApiModelProperty(value = "年级" )
    private Integer grade;

    @Column(name = "major" )
    @ApiModelProperty(value = "专业" )
    private String major;

    @Column(name = "phone" )
    @ApiModelProperty(value = "手机号" )
    private String phone;

    @Column(name = "email" )
    @ApiModelProperty(value = "邮箱" )
    private String email;

    @Column(name = "created_by" )
    @ApiModelProperty(value = "创建者" )
    private Integer createdBy;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;

    @Column(name = "update_by" )
    @ApiModelProperty(value = "更新者" )
    private Integer updateBy;

    @Column(name = "update_time" )
    @ApiModelProperty(value = "更新时间" )
    private Date updateTime;

}
