package com.softlogia.framework.model.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.softlogia.framework.domain.BaseDomain;
/**
 * Super clase de todos los DAO Impl
 * @author Pablo Marquez
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T extends BaseDomain> extends HibernateDaoSupport {


	/**
	 * Almacenar la entidad
	 * @param object
	 */
	public void save(T object) {
		this.getHibernateTemplate().save(object);
		
	}


	/**
	 * Borrar la entidad
	 * @param object
	 */
	public void update(T object) {
		this.getHibernateTemplate().update(object);
		
	}


	/**
	 * Realiza la eliminación de un objeto
	 * @param object
	 */
	public void delete(T object) {
		this.getHibernateTemplate().delete(object);
		
	}



	

}
