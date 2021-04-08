package com.sjzxy.fwpt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description= "major")
@Entity
@Table(name = "major")
@Data
public class Major implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "id" )
    private Integer id;

    @Column(name = "college" )
    @ApiModelProperty(value = "学院" )
    private Integer college;

    @Column(name = "major" )
    @ApiModelProperty(value = "专业" )
    private String major;

}
