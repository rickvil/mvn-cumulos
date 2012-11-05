package com.softlogia.framework.domain;

import java.io.Serializable;

public class RoleUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private Long idRole;
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRol) {
		this.idRole = idRol;
	}
	
	
}
