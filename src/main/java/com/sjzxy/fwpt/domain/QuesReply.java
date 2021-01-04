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
@ApiModel(description= "ques_reply-回答表")
@Entity
@Table ( name ="ques_reply" , schema = "")
public class QuesReply  implements Serializable {

	private static final long serialVersionUID =  2838824988858106130L;

	/**
	 * 回答id
	 */
	@ApiModelProperty(value = "回答id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 回答对应的问题id
	 */
	@ApiModelProperty(value = "回答对应的问题id")
   	@Column(name = "qid" )
	private Long qid;

	/**
	 * 回答创建者
	 */
	@ApiModelProperty(value = "回答创建者")
   	@Column(name = "create_by" )
	private Long createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
   	@Column(name = "cerate_time" )
	private Date cerateTime;

	/**
	 * 具体内容
	 */
	@ApiModelProperty(value = "具体内容")
   	@Column(name = "content" )
	private String content;

}
