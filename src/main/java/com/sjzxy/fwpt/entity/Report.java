package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "report")
@Entity
@Table(name = "report")
@Data
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "举报信息id" )
    private Integer id;

    @Column(name = "content" )
    @ApiModelProperty(value = "content" )
    private String content;

    @Column(name = "uid" )
    @ApiModelProperty(value = "举报人id" )
    private Integer uid;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;
}
