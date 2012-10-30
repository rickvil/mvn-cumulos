package com.softlogia.framework.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;

@ManagedBean(name = "roleGestionBean")
@RequestScoped
public class RoleGestionBean extends BaseBean {
	
	private User selectedUser= new User();
	private Role selectedRole = new Role();
	private List<SelectItem> listSource= new ArrayList<SelectItem>();
	private Long idRole;
	
	public RoleGestionBean(){
	}
	
	public void doCargarRoleForm(ComponentSystemEvent event) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		Long id=(Long)flash.get("userId");
		System.out.println("DO CARGAR ROLE FORM->"+id);
		if (id!=null){
			this.selectedUser=getProyectoServices().getUserService().getUserById(id);
		}
		
	}
	public String doAddRole(){
		System.out.println("EVENTO");
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("userId", this.selectedUser.getId());
		flash.setKeepMessages(true);
		this.getProyectoServices().getUserService().addRoleToUser(this.selectedUser.getId(),this.idRole); 	 
		return null;
	}
	
	public String doDeleteRole(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("userId", this.selectedUser.getId());
		flash.setKeepMessages(true);		
		this.getProyectoServices().getUserService().removeRoleToUser(this.selectedUser.getId(),this.selectedRole.getId());
		return null;
	}
///////////////////////////////////////////////////
	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<SelectItem> getListSource() {
		return listSource;
	}

	public void setListSource(List<SelectItem> listSource) {
		this.listSource = listSource;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}
	
	
}
