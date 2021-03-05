package com.sjzxy.fwpt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(description= "mood")
@Entity
@Table(name = "mood")
@Data
public class Mood implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "mood——id")
    private Integer id;

    @Column(name = "content")
    @ApiModelProperty(value = "心情")
    private String content;

    @Column(name = "uid")
    @ApiModelProperty(value = "提交信息的用户id")
    private Integer uid;

    @Column(name = "create_time")
    @ApiModelProperty(value = "提交时间")
    private Date createTime;

    @Column(name = "nick")
    @ApiModelProperty(value = "昵称")
    private String nick;
}

