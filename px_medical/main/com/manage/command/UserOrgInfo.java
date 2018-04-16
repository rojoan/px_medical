package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.utils.NullBeanUtils;

public class UserOrgInfo extends BaseCommandInfo {
    private static final long serialVersionUID = -5843054191032304986L;

    private Long rootOrgId;
    private String name;
    private String account;
    private String code;
    private String phone;
    private boolean multi;
    
    public UserOrgInfo() {
        
    }
    public UserOrgInfo(UserOrgInfo info) {
         NullBeanUtils.copyProperties(this, info);
    }
    public Long getRootOrgId() {
        return rootOrgId;
    }

    public void setRootOrgId(Long rootOrgId) {
        this.rootOrgId = rootOrgId;
    }

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
