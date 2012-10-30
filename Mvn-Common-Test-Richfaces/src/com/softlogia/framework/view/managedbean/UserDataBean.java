package com.softlogia.framework.view.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.softlogia.framework.domain.User;

@ManagedBean(name = "userDataBean")
@RequestScoped
public class UserDataBean extends BaseBean{
	private List<User> userList;
	
	public UserDataBean(){
		this.userList = getProyectoServices().getUserService().getUserList(new User());
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
