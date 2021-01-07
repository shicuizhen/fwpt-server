package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "lost_information")
@Entity
@Table(name = "lost_information")
@Data
public class LostInformation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "物品id" )
    private Integer id;

    @Column(name = "name" )
    @ApiModelProperty(value = "物品名称" )
    private String name;

    @Column(name = "type" )
    @ApiModelProperty(value = "启事类型（失物0，拾遗1）" )
    private Integer type;

    @Column(name = "kind_id" )
    @ApiModelProperty(value = "物品种类" )
    private Integer kindId;

    @Column(name = "description" )
    @ApiModelProperty(value = "物品信息描述" )
    private String description;

    @Column(name = "username" )
    @ApiModelProperty(value = "失主或拾主姓名" )
    private String username;

    @Column(name = "place_id" )
    @ApiModelProperty(value = "丢失/拾遗地点" )
    private Integer placeId;

    @Column(name = "position" )
    @ApiModelProperty(value = "丢失/拾遗详细位置" )
    private String position;

    @Column(name = "lost_time" )
    @ApiModelProperty(value = "丢失/拾遗时间" )
    private Date lostTime;

    @Column(name = "telephone" )
    @ApiModelProperty(value = "联系方式：手机号" )
    private String telephone;

    @Column(name = "email" )
    @ApiModelProperty(value = "联系方式：邮箱" )
    private String email;

    @Column(name = "create_by" )
    @ApiModelProperty(value = "信息登记者id" )
    private Integer createBy;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "登记时间" )
    private Date createTime;

    @Column(name = "state_id" )
    @ApiModelProperty(value = "物品当前状态（0未完成，1认领成功）" )
    private Integer stateId;

}
