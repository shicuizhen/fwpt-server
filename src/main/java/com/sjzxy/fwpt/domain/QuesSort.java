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
@ApiModel(description= "ques_sort-咨询信息类别表")
@Entity
@Table ( name ="ques_sort" , schema = "")
public class QuesSort  implements Serializable {

	private static final long serialVersionUID =  5939481198114077769L;

	/**
	 * 类别id
	 */
	@ApiModelProperty(value = "类别id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 父类id（根分类的父分类id为0）
	 */
	@ApiModelProperty(value = "父类id（根分类的父分类id为0）")
   	@Column(name = "pid" )
	private Long pid;

	/**
	 * 类别名
	 */
	@ApiModelProperty(value = "类别名")
   	@Column(name = "name" )
	private String name;

	/**
	 * 类别详情介绍
	 */
	@ApiModelProperty(value = "类别详情介绍")
   	@Column(name = "depression" )
	private String depression;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
   	@Column(name = "create_time" )
	private Date createTime;

}
