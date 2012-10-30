package com.softlogia.framework.view.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.softlogia.framework.model.services.ProyectoServices;
import com.softlogia.framework.view.utils.SpringUtils;

public class BaseBean  {

	public int sumar(){
		return 24;
	}
	
	public void showMessage(String title, String content) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(title, content));
	}
	
	protected ProyectoServices getProyectoServices(){
		return (ProyectoServices) SpringUtils.applicationContext.getBean("proyectoServices");
	}
}
