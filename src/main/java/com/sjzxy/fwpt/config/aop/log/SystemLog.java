package com.sjzxy.fwpt.config.aop.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "system_logs")
@Entity
@Getter
@Setter
@ToString
public class SystemLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "operator", nullable = false, length = 100)
    private String operator;

    @Column(name = "operate_method", nullable = false)
    private String operateMethod;

    @Column(name = "operate_params", length = 100)
    private String operateParams;

    @Column(name = "operate_desc", length = 100)
    private String operateDesc;

    @Column(name = "operate_result", nullable = false, length = 100)
    private String operateResult;

    @Column(name = "ip", nullable = false, length = 20)
    private String ip;

    @Column(name = "operate_date", nullable = false)
    private Date operateDate;

}
