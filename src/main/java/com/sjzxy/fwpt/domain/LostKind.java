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
@ApiModel(description= "lost_kind-丢失物品种类表")
@Entity
@Table ( name ="lost_kind" , schema = "")
public class LostKind  implements Serializable {

	private static final long serialVersionUID =  2239528263099016959L;

	/**
	 * 物品类型id
	 */
	@ApiModelProperty(value = "物品类型id")
	@Id
   	@Column(name = "id" )
	private Long id;

	/**
	 * 物品种类名称
	 */
	@ApiModelProperty(value = "物品种类名称")
   	@Column(name = "name" )
	private String name;

}
