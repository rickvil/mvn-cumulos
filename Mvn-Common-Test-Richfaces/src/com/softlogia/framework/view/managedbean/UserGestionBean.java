package com.softlogia.framework.view.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;

import com.softlogia.framework.domain.User;

@ManagedBean(name = "userGestionBean")
@RequestScoped
public class UserGestionBean extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> userList;
	private User selectedUser = new User();
	private String action = "";

	public UserGestionBean() {
	}

	public String doDeleteUserNavigation() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("action", action);
		flash.put("userId", this.selectedUser.getId());
		flash.setKeepMessages(true);
		return "userForm.xhtml?faces-redirect=true";
	}

	public String doUpdateUserNavigation() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("action", action);
		flash.put("userId", this.selectedUser.getId());
		flash.setKeepMessages(true);
		return "userForm.xhtml?faces-redirect=true";
	}

	public String doNewUserNavigation() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("action", action);
		flash.setKeepMessages(true);
		return "userForm.xhtml?faces-redirect=true";
	}

	public String doUpdateRoleNavigation() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("userId", this.selectedUser.getId());
		flash.setKeepMessages(true);
		return "roleForm.xhtml?faces-redirect=true";
	}

	public void doCargarUserForm(ComponentSystemEvent event) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		String actio = (String) flash.get("action");
		this.action = actio;
		if (actio != null && !actio.equalsIgnoreCase("new")) {
			System.out.println(flash.get("userId"));
			Long id = (Long) flash.get("userId");
			this.selectedUser = getProyectoServices().getUserService().getUserById(id);
		}
		if (action.equalsIgnoreCase("new")) {
			action = "Save";
		} else if (action.equalsIgnoreCase("delete")) {
			action = "Delete";
		} else {
			action = "Save changes";
		}
	}

	public String doOperation() {
		if (action.equalsIgnoreCase("save")) {
			getProyectoServices().getUserService().saveUser(this.selectedUser);
		} else if (action.equalsIgnoreCase("delete")) {
			getProyectoServices().getUserService().deleteUser(this.selectedUser);
		} else {
			getProyectoServices().getUserService().updateUser(this.selectedUser);
		}
		return "userCrud.xhtml?faces-redirect=true";
	}

	public void doCargarCrudForm(ComponentSystemEvent event) {
	}

	// /////////////////////////////////////////////////////////////////////

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
