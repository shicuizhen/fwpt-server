package com.sjzxy.fwpt.doamin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @data 2020-11-23 17:20:20
 * @author scz
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private int id;

    private String username;
}
