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
@ApiModel(description= "lost_claim-认领归还记录表")
@Entity
@Table ( name ="lost_claim" , schema = "")
public class LostClaim  implements Serializable {

	private static final long serialVersionUID =  7865801909928659109L;

	/**
	 * 记录id
	 */
	@ApiModelProperty(value = "记录id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 启事id
	 */
	@ApiModelProperty(value = "启事id")
   	@Column(name = "iid" )
	private Long iid;

	/**
	 * 该条记录的创建者id
	 */
	@ApiModelProperty(value = "该条记录的创建者id")
   	@Column(name = "create_id" )
	private Long createId;

	/**
	 * 联系方式：手机号
	 */
	@ApiModelProperty(value = "联系方式：手机号")
   	@Column(name = "telephone" )
	private String telephone;

	/**
	 * 联系方式：邮箱
	 */
	@ApiModelProperty(value = "联系方式：邮箱")
   	@Column(name = "email" )
	private String email;

	/**
	 * 记录生成时间
	 */
	@ApiModelProperty(value = "记录生成时间")
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 当前请求状态（0认领中，1认领成功，3认领失效）
	 */
	@ApiModelProperty(value = "当前请求状态（0认领中，1认领成功，3认领失效）")
   	@Column(name = "sid" )
	private Long sid;

}
