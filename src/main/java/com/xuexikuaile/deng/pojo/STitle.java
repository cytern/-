package com.xuexikuaile.deng.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * s_title
 * @author 
 */
@Data
public class STitle implements Serializable {
    /**
     * 公告id
     */
    private Integer sTitleId;

    /**
     * 公告标题
     */
    private String sTitleTitle;

    /**
     * 公告内容
     */
    private String sTitleConf;

    private Integer startUserId;

    private Date cTime;

    private static final long serialVersionUID = 1L;
}