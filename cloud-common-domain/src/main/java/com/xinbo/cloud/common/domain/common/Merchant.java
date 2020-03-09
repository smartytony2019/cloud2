package com.xinbo.cloud.common.domain.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchant")
public class Merchant {


    private static final long serialVersionUID = -1841231686851699943L;

    /**
     * 商户id
     */
    @Id
    @Column(name = "MerchantId")
    private Long MerchantId;

    /**
     * 商户编号
     */
    @Column(name = "MerchantCode")
    private String MerchantCode;

    /**
     * 商户名称
     */
    @Column(name = "MerchantName")
    private String MerchantName;

    /**
     * 添加时间
     */
    @Column(name = "AddTime")
    private Date AddTime;

    /**
     * 商户状态
     */
    @Column(name = "Status")
    private boolean Status;

    /**
     * 商户密钥
     */
    @Column(name = "MerchantKey")
    private String MerchantKey;

    /**
     * 商户密码
     */
    @Column(name = "PassWord")
    private String PassWord;

    /**
     * Api地址
     */
    @Column(name = "ApiAddress")
    private String ApiAddress;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String Remark;

    /**
     * 排序
     */
    @Column(name = "Sort")
    private int Sort;

    /**
     * 数据节点(枚举:EnumMyCatDataNode)
     */
    @Column(name = "DataNode")
    private int DataNode;


}
