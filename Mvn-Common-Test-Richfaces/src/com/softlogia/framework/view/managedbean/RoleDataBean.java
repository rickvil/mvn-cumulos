package com.softlogia.framework.view.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;

@ManagedBean(name = "roleDataBean")
@ViewScoped
public class RoleDataBean extends BaseBean implements Serializable{
	private List<Role> roleList;
	private List<Role> roleListParticular;
	

	public RoleDataBean() {
		
	}
	
	public void doCargarRoleForm(ComponentSystemEvent event) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		Long id=(Long) flash.get("userId");
		System.out.println("ROLE DATA BEAN->"+id);
		if (id != null) {
			User user = new User();
			user.setId(id);
			this.roleList=getProyectoServices().getUserService().getRoleList(user);
			this.roleListParticular=getProyectoServices().getUserService().getUserRoleListNot(id);
		}
		
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Role> getRoleListParticular() {
		return roleListParticular;
	}

	public void setRoleListParticular(List<Role> roleListParticular) {
		this.roleListParticular = roleListParticular;
	}
	
	
	
}
