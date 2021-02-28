package com.sjzxy.fwpt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description= "userLogin")
@Entity
@Data
public class UserLogin implements Serializable {

    @Id
    @Column(name = "sno" )
    @ApiModelProperty(value = "学号" )
    private String sno;

    @Column(name = "password" )
    @ApiModelProperty(value = "密码" )
    private String password;

}
