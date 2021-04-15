package com.sjzxy.fwpt.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "manager")
@Entity
@Table(name = "manager")
@Data
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "id" )
    private Integer id;

    @Column(name = "uid" )
    @ApiModelProperty(value = "uid" )
    private Integer uid;


}
