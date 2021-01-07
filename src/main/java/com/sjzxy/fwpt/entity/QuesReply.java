package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "ques_reply")
@Entity
@Table(name = "ques_reply")
@Data
public class QuesReply implements Serializable {

    @Id
    @Column(name = "id" )
    @ApiModelProperty(value = "回答id" )
    private Integer id;

    @Column(name = "qid" )
    @ApiModelProperty(value = "回答对应的问题id" )
    private Integer qid;

    @Column(name = "create_by" )
    @ApiModelProperty(value = "回答创建者" )
    private Integer createBy;

    @Column(name = "cerate_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date cerateTime;

    @Column(name = "content" )
    @ApiModelProperty(value = "具体内容" )
    private String content;

}
