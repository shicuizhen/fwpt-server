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
@ApiModel(description= "lost_place-学校位置信息表")
@Entity
@Table ( name ="lost_place" , schema = "")
public class LostPlace  implements Serializable {

	private static final long serialVersionUID =  6753845570384050078L;

	/**
	 * 地点id
	 */
	@ApiModelProperty(value = "地点id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 学校地点名称
	 */
	@ApiModelProperty(value = "学校地点名称")
   	@Column(name = "name" )
	private String name;

}
