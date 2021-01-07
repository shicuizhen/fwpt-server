package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "approve")
@Entity
@Table(name = "approve")
@Data
public class Approve implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "审批信息id" )
    private Integer id;

    @Column(name = "uid" )
    @ApiModelProperty(value = "提交信息的用户id" )
    private Integer uid;

    @Column(name = "sno" )
    @ApiModelProperty(value = "学号" )
    private String sno;

    @Column(name = "name" )
    @ApiModelProperty(value = "姓名" )
    private String name;

    @Column(name = "grade" )
    @ApiModelProperty(value = "年级" )
    private Integer grade;

    @Column(name = "major" )
    @ApiModelProperty(value = "专业" )
    private String major;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "提交审批信息时间" )
    private Date createTime;

}
