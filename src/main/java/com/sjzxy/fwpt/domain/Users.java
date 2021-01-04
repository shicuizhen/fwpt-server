package com.sjzxy.fwpt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author  linmengmeng
 * @Date 2020-12-31 16:25:06
 */
@Data
@ApiModel(description= "users-用户信息表")
@Entity
@Table ( name ="users" , schema = "")
public class Users  implements Serializable {

	private static final long serialVersionUID =  1262657070103814689L;

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 学号
	 */
	@ApiModelProperty(value = "学号")
   	@Column(name = "sno" )
	private String sno;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
   	@Column(name = "name" )
	private String name;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
   	@Column(name = "password" )
	private String password;

	/**
	 * 昵称
	 */
	@ApiModelProperty(value = "昵称")
   	@Column(name = "nick" )
	private String nick;

	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
   	@Column(name = "sex" )
	private Long sex;

	/**
	 * 出生日期
	 */
	@ApiModelProperty(value = "出生日期")
   	@Column(name = "birthday" )
	private Date birthday;

	/**
	 * 头像地址
	 */
	@ApiModelProperty(value = "头像地址")
   	@Column(name = "photo_address" )
	private String photoAddress;

	/**
	 * 年级
	 */
	@ApiModelProperty(value = "年级")
   	@Column(name = "grade" )
	private Long grade;

	/**
	 * 专业
	 */
	@ApiModelProperty(value = "专业")
   	@Column(name = "major" )
	private String major;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
   	@Column(name = "phone" )
	private String phone;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
   	@Column(name = "email" )
	private String email;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者")
   	@Column(name = "created_by" )
	private Long createdBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 更新者
	 */
	@ApiModelProperty(value = "更新者")
   	@Column(name = "update_by" )
	private Long updateBy;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
   	@Column(name = "update_time" )
	private Date updateTime;

}
