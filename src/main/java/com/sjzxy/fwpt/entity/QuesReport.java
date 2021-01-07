package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "ques_report")
@Entity
@Table(name = "ques_report")
@Data
public class QuesReport implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "举报信息id" )
    private Integer id;

    @Column(name = "qid" )
    @ApiModelProperty(value = "问题id" )
    private Integer qid;

    @Column(name = "rid" )
    @ApiModelProperty(value = "回答id" )
    private Integer rid;

    @Column(name = "cid" )
    @ApiModelProperty(value = "评论id" )
    private Integer cid;

    @Column(name = "uid" )
    @ApiModelProperty(value = "举报人id" )
    private Integer uid;

}
