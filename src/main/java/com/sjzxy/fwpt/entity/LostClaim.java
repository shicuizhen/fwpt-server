package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "lost_claim")
@Entity
@Table(name = "lost_claim")
@Data
public class LostClaim implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "记录id" )
    private Integer id;

    @Column(name = "iid" )
    @ApiModelProperty(value = "启事id" )
    private Integer iid;

    @Column(name = "create_id" )
    @ApiModelProperty(value = "该条记录的创建者id" )
    private Integer createId;

    @Column(name = "telephone" )
    @ApiModelProperty(value = "联系方式：手机号" )
    private String telephone;

    @Column(name = "email" )
    @ApiModelProperty(value = "联系方式：邮箱" )
    private String email;

    @Column(name = "create_time" )
    @ApiModelProperty(value = "记录生成时间" )
    private Date createTime;

    @Column(name = "sid" )
    @ApiModelProperty(value = "当前请求状态（0认领中，1认领成功，3认领失效）" )
    private Integer sid;

}
