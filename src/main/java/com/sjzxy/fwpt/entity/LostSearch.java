package com.sjzxy.fwpt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description= "lost_search")
@Entity
@Data
public class LostSearch implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id" )
    @ApiModelProperty(value = "id" )
    public Integer id;

    public Integer getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public Integer getKind_id() {
        return kind_id;
    }

    public Integer getPlace_id() {
        return place_id;
    }

    public Date getLost_time1() {
        return lost_time1;
    }

    public Date getLost_time2() {
        return lost_time2;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getSearch_key() {
        return search_key;
    }

    @Column(name = "type" )
    @ApiModelProperty(value = "类型" )
    public Integer type;

    @Column(name = "kind_id" )
    @ApiModelProperty(value = "种类id" )
    public Integer kind_id;

    @Column(name = "place_id" )
    @ApiModelProperty(value = "地点id" )
    public Integer place_id;

    @Column(name = "lost_time1" )
    @ApiModelProperty(value = "丢失时间1" )
    public Date lost_time1;

    @Column(name = "lost_time2" )
    @ApiModelProperty(value = "丢失时间2" )
    public Date lost_time2;

    @Column(name = "pageNo" )
    @ApiModelProperty(value = "当前页码" )
    Integer pageNo;

    @Column(name = "pageSize" )
    @ApiModelProperty(value = "当前页面量" )
    Integer pageSize;

    @Column(name = "search_key" )
    @ApiModelProperty(value = "搜索框中的字段" )
    String search_key;

}
