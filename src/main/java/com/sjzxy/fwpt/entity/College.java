package com.sjzxy.fwpt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description= "college")
@Entity
@Table(name = "college")
@Data
public class College implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "id" )
    private Integer id;

    @Column(name = "college" )
    @ApiModelProperty(value = "学院名" )
    private String college;

}
