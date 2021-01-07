package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "lost_kind")
@Entity
@Table(name = "lost_kind")
@Data
public class LostKind implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "物品类型id" )
    private Integer id;

    @Column(name = "name" )
    @ApiModelProperty(value = "物品种类名称" )
    private String name;

}
