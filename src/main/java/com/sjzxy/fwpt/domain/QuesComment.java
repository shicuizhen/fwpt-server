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
@ApiModel(description= "ques_comment-问题评论表")
@Entity
@Table ( name ="ques_comment" , schema = "")
public class QuesComment  implements Serializable {

	private static final long serialVersionUID =  1831131591332228077L;

	/**
	 * 评论id
	 */
	@ApiModelProperty(value = "评论id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 评论对应的回答id
	 */
	@ApiModelProperty(value = "评论对应的回答id")
   	@Column(name = "rid" )
	private Long rid;

	/**
	 * 创建者id
	 */
	@ApiModelProperty(value = "创建者id")
   	@Column(name = "create_by" )
	private Long createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 具体内容
	 */
	@ApiModelProperty(value = "具体内容")
   	@Column(name = "content" )
	private String content;

	/**
	 * 安特的用户id
	 */
	@ApiModelProperty(value = "安特的用户id")
   	@Column(name = "at" )
	private Long at;

}
