package com.softlogia.framework.view.utils;

import javax.el.ELResolver;
import javax.faces.context.FacesContext;

/**
 *
 * @author SRodriguez
 */
public class FacesUtil {

    public static Object getManagedBean(String name) {
        return getELResolver().getValue(getFacesContext().getELContext(), null, name);
    }

    private static ELResolver getELResolver() {
        return getFacesContext().getApplication().getELResolver();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static final String getRequestParameter(String name) {
        return getFacesContext().getExternalContext().getRequestParameterMap().get(name);
    }
}
