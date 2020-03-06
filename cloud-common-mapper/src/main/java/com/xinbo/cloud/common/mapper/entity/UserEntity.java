package com.xinbo.cloud.common.mapper.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -1840831686851699943L;

    /**
     * 主键
     */
    @Setter @Getter  private Long id;

    /**
     * 用户名
     */
    @Setter @Getter private String name;

    /**
     * 加密后的密码
     */
    @Setter @Getter private String password;

    /**
     * 加密使用的盐
     */
    @Setter @Getter private String salt;

    /**
     * 邮箱
     */
    @Setter @Getter private String email;

    /**
     * 手机号码
     */
    @Setter @Getter private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    @Setter @Getter private Integer status;

    /**
     * 创建时间
     */
    @Setter @Getter private Date createTime;

    /**
     * 上次登录时间
     */
    @Setter @Getter private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    @Setter @Getter private Date lastUpdateTime;

}
