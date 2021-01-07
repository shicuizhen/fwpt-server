package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "ques_comment")
@Entity
@Table(name = "ques_comment")
@Data
public class QuesComment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "评论id" )
    private Integer id;

    @Column(name = "rid" )
    @ApiModelProperty(value = "评论对应的回答id" )
    private Integer rid;

    @Column(name = "create_by" )
    @ApiModelProperty(value = "创建者id" )
    private Integer createBy;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;

    @Column(name = "content" )
    @ApiModelProperty(value = "具体内容" )
    private String content;

    @Column(name = "at" )
    @ApiModelProperty(value = "安特的用户id" )
    private Integer at;

}
