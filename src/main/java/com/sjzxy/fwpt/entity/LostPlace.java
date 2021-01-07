package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "lost_place")
@Entity
@Table(name = "lost_place")
@Data
public class LostPlace implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "地点id" )
    private Integer id;

    @Column(name = "name" )
    @ApiModelProperty(value = "学校地点名称" )
    private String name;

}
