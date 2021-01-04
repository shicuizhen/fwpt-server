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
@ApiModel(description= "information-失物/拾遗物品信息表")
@Entity
@Table ( name ="lost_information" , schema = "")
public class LostInformation  implements Serializable {

	private static final long serialVersionUID =  781503925446100040L;

	/**
	 * 物品id
	 */
	@ApiModelProperty(value = "物品id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 物品名称
	 */
	@ApiModelProperty(value = "物品名称")
   	@Column(name = "name" )
	private String name;

	/**
	 * 启事类型（失物0，拾遗1）
	 */
	@ApiModelProperty(value = "启事类型（失物0，拾遗1）")
   	@Column(name = "type" )
	private Long type;

	/**
	 * 物品种类
	 */
	@ApiModelProperty(value = "物品种类")
   	@Column(name = "kind_id" )
	private Long kindId;

	/**
	 * 物品信息描述
	 */
	@ApiModelProperty(value = "物品信息描述")
   	@Column(name = "description" )
	private String description;

	/**
	 * 失主或拾主姓名
	 */
	@ApiModelProperty(value = "失主或拾主姓名")
   	@Column(name = "username" )
	private String username;

	/**
	 * 丢失/拾遗地点
	 */
	@ApiModelProperty(value = "丢失/拾遗地点")
   	@Column(name = "place_id" )
	private Long placeId;

	/**
	 * 丢失/拾遗详细位置
	 */
	@ApiModelProperty(value = "丢失/拾遗详细位置")
   	@Column(name = "position" )
	private String position;

	/**
	 * 丢失/拾遗时间
	 */
	@ApiModelProperty(value = "丢失/拾遗时间")
   	@Column(name = "lost_time" )
	private Date lostTime;

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
	 * 信息登记者id
	 */
	@ApiModelProperty(value = "信息登记者id")
   	@Column(name = "create_by" )
	private Long createBy;

	/**
	 * 登记时间
	 */
	@ApiModelProperty(value = "登记时间")
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 物品当前状态（0未完成，1认领成功）
	 */
	@ApiModelProperty(value = "物品当前状态（0未完成，1认领成功）")
   	@Column(name = "state_id" )
	private Long stateId;

}
