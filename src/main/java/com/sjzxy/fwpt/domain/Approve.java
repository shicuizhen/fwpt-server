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
@ApiModel(description= "approve-用户审批表")
@Entity
@Table ( name ="approve" , schema = "")
public class Approve  implements Serializable {

	private static final long serialVersionUID =  5629870531145478384L;

	/**
	 * 审批信息id
	 */
	@ApiModelProperty(value = "审批信息id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 提交信息的用户id
	 */
	@ApiModelProperty(value = "提交信息的用户id")
   	@Column(name = "uid" )
	private Long uid;

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
	 * 提交审批信息时间
	 */
	@ApiModelProperty(value = "提交审批信息时间")
   	@Column(name = "create_time" )
	private Date createTime;

}
