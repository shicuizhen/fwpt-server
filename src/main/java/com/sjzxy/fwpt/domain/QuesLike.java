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

/**
 * @Description
 * @Author  linmengmeng
 * @Date 2020-12-31 16:25:06
 */
@Data
@ApiModel(description= "ques_like-点赞表")
@Entity
@Table ( name ="ques_like" , schema = "")
public class QuesLike  implements Serializable {

	private static final long serialVersionUID =  5641748154803697241L;

	/**
	 * 点赞id
	 */
	@ApiModelProperty(value = "点赞id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 问题id
	 */
	@ApiModelProperty(value = "问题id")
   	@Column(name = "qid" )
	private Long qid;

	/**
	 * 回答id
	 */
	@ApiModelProperty(value = "回答id")
   	@Column(name = "rid" )
	private Long rid;

	/**
	 * 评论id
	 */
	@ApiModelProperty(value = "评论id")
   	@Column(name = "cid" )
	private Long cid;

	/**
	 * 点赞的用户id
	 */
	@ApiModelProperty(value = "点赞的用户id")
   	@Column(name = "uid" )
	private Long uid;

	/**
	 * 点赞状态（当前该信息是否被该用户赞）
	 */
	@ApiModelProperty(value = "点赞状态（当前该信息是否被该用户赞）")
   	@Column(name = "state" )
	private Long state;

}
