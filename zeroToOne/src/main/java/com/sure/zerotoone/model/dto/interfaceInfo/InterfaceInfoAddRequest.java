package com.sure.zerotoone.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 添加接口请求
 * @TableName interface_info
 */

@Data
public class InterfaceInfoAddRequest implements Serializable {



    private static final long serialVersionUID = 2159334071757954795L;
    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;



    /**
     * 请求类型
     */
    private String method;




}