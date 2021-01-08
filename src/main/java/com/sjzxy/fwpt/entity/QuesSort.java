package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "ques_sort")
@Entity
@Table(name = "ques_sort")
@Data
public class QuesSort implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "类别id" )
    private Integer id;

    @Column(name = "pid" )
    @ApiModelProperty(value = "父类id（根分类的父分类id为0）" )
    private Integer pid;

    @Column(name = "name" )
    @ApiModelProperty(value = "类别名" )
    private String name;

    @Column(name = "depression" )
    @ApiModelProperty(value = "类别详情介绍" )
    private String depression;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;

}
