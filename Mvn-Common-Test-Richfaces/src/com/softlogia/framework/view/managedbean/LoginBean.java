package com.softlogia.framework.view.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.softlogia.framework.view.utils.SpringUtils;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean extends BaseBean{

	private String user;
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin(){
		System.out.println("DO LOGIN");
		/*BaseBean base=(BaseBean)SpringUtils.applicationContext.getBean("beanPrueba");
		System.out.println(base.sumar());
		System.out.println(SpringUtils.applicationContext.getBean("myDataSource"));
		return null;//*/
		return "pages/userCrud.xhtml?faces-redirect=true";
	}
}
