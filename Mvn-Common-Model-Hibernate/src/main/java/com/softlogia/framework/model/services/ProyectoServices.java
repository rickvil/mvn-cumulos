package com.softlogia.framework.model.services;

import com.softlogia.framework.model.services.UserService;
/**
 * Esta clase contiene todos los servicios disponibles del modelo
 * @author Pablo Marquez
 *
 */
public class ProyectoServices {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	
}
	
