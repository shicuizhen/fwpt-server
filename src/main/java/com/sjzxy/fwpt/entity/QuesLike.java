package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "ques_like")
@Entity
@Table(name = "ques_like")
@Data
public class QuesLike implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "点赞id" )
    private Integer id;

    @Column(name = "qid" )
    @ApiModelProperty(value = "问题id" )
    private Integer qid;

    @Column(name = "rid" )
    @ApiModelProperty(value = "回答id" )
    private Integer rid;

    @Column(name = "uid" )
    @ApiModelProperty(value = "点赞的用户id" )
    private Integer uid;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;
}
