package com.softlogia.framework.domain;

import java.io.Serializable;

/**
 * 
 * @author Pablo Marquez
 *
 */
public class BaseDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Auditoria auditoria;

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}
	
}
