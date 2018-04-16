/*
 * <p> Title:  UserRoleInfo.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * <p> Calss Name:  PasswordInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2018-3-18
 */
@SuppressWarnings("serial")
public class PasswordInfo extends BaseCommandInfo{

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;

    private String oldPhone;

    private String newPhone;

    public String getOldPassword() {
        return oldPassword;
    }


    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public String getNewPassword() {
        return newPassword;
    }


    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }


    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


	public String getOldPhone() {
		return oldPhone;
	}


	public void setOldPhone(String oldPhone) {
		this.oldPhone = oldPhone;
	}


	public String getNewPhone() {
		return newPhone;
	}


	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}


}
