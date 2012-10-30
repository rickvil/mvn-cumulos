package com.softlogia.framework.view.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;


public class SpringUtils {
	public static ApplicationContext applicationContext = FacesContextUtils.getWebApplicationContext(FacesUtil.getFacesContext());
}
