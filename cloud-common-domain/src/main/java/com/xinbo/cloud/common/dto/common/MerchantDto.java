package com.xinbo.cloud.common.dto.common;


import java.util.Date;

public class MerchantDto {

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
     * 状态标签
     */
    private String statusLable;

    public String getStatusLable() {
        return this.Status ? "开启": "禁用";
    }

    /**
     * 排序
     */
    private int Sort;

    public Long getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(Long merchantId) {
        MerchantId = merchantId;
    }

    public String getMerchantCode() {
        return MerchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        MerchantCode = merchantCode;
    }

    public String getMerchantName() {
        return MerchantName;
    }

    public void setMerchantName(String merchantName) {
        MerchantName = merchantName;
    }

    public Date getAddTime() {
        return AddTime;
    }

    public void setAddTime(Date addTime) {
        AddTime = addTime;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getMerchantKey() {
        return MerchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        MerchantKey = merchantKey;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public double getCreditAmount() {
        return CreditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        CreditAmount = creditAmount;
    }

    public double getUsedAmount() {
        return UsedAmount;
    }

    public void setUsedAmount(double usedAmount) {
        UsedAmount = usedAmount;
    }

    public double getBetAmount() {
        return BetAmount;
    }

    public void setBetAmount(double betAmount) {
        BetAmount = betAmount;
    }

    public double getPrizeAmount() {
        return PrizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        PrizeAmount = prizeAmount;
    }

    public String getApiAddress() {
        return ApiAddress;
    }

    public void setApiAddress(String apiAddress) {
        ApiAddress = apiAddress;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int sort) {
        Sort = sort;
    }




}
