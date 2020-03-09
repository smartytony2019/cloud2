package com.xinbo.cloud.common.vo.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantVo {

    /**
     * 商户id
     */
    private Long MerchantId;

    /**
     * 商户编号
     */
    private String MerchantCode;

    /**
     * 商户名称
     */
    private String MerchantName;

    /**
     * 添加时间
     */
    private Date AddTime;

    /**
     * 商户状态
     */
    private boolean Status;

    /**
     * 商户密钥
     */
    private String MerchantKey;

    /**
     * 商户密码
     */
    private String PassWord;

    /**
     * 授信额度
     */
    private double CreditAmount;

    /**
     * 已使用额度(中奖金额-投注金额)
     */
    private double UsedAmount;

    /**
     * 投注金额
     */
    private double BetAmount;

    /**
     * 中奖金额
     */
    private double PrizeAmount;

    /**
     * Api地址
     */
    private String ApiAddress;

    /**
     * 备注
     */
    private String Remark;

    /**
     * 排序
     */
    private int Sort;

    /**
     * 数据节点(枚举:EnumMyCatDataNode)
     */
    private int DataNode;


}
