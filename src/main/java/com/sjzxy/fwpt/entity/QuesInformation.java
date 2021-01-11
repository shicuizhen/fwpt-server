package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "ques_information")
@Entity
@Table(name = "ques_information")
@Data
public class QuesInformation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "问题id" )
    private Integer id;

    @Column(name = "sort_id" )
    @ApiModelProperty(value = "问题类别id" )
    private Integer sortId;

    @Column(name = "create_by" )
    @ApiModelProperty(value = "创建者" )
    private Integer createBy;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;

    @Column(name = "title" )
    @ApiModelProperty(value = "问题标题" )
    private String title;

    @Column(name = "content" )
    @ApiModelProperty(value = "问题具体内容" )
    private String content;

    @Column(name = "is_finish" )
    @ApiModelProperty(value = "问题是否被解决" )
    private Integer isFinish;

}
