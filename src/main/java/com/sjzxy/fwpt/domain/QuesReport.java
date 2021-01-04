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
@ApiModel(description= "ques_report-举报表")
@Entity
@Table ( name ="ques_report" , schema = "")
public class QuesReport  implements Serializable {

	private static final long serialVersionUID =  5234528896537399260L;

	/**
	 * 举报信息id
	 */
	@ApiModelProperty(value = "举报信息id")
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
	 * 举报人id
	 */
	@ApiModelProperty(value = "举报人id")
   	@Column(name = "uid" )
	private Long uid;

}
