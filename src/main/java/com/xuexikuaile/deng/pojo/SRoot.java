package com.xuexikuaile.deng.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * s_root
 * @author 
 */
@Data
public class SRoot implements Serializable {
    private Integer sRootId;

    private String sRootName;

    private String sRootPhone;

    private Integer userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uTime;

    private static final long serialVersionUID = 1L;
}