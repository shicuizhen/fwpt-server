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
@ApiModel(description= "ques_information-失物/拾遗物品信息表")
@Entity
@Table ( name ="ques_information" , schema = "")
public class QuesInformation  implements Serializable {

	private static final long serialVersionUID =  2641143636698769956L;

	/**
	 * 问题id
	 */
	@ApiModelProperty(value = "问题id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 问题类别id
	 */
	@ApiModelProperty(value = "问题类别id")
   	@Column(name = "sort_id" )
	private Long sortId;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者")
   	@Column(name = "create_by" )
	private Long createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 问题标题
	 */
	@ApiModelProperty(value = "问题标题")
   	@Column(name = "title" )
	private String title;

	/**
	 * 问题具体内容
	 */
	@ApiModelProperty(value = "问题具体内容")
   	@Column(name = "content" )
	private String content;

	/**
	 * 问题是否被解决
	 */
	@ApiModelProperty(value = "问题是否被解决")
   	@Column(name = "is_finish" )
	private Long isFinish;

}
