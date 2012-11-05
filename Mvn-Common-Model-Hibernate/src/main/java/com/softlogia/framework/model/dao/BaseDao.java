package com.softlogia.framework.model.dao;

import com.softlogia.framework.domain.BaseDomain;


/**
 * 
 * @author Pablo Marquez
 *
 * @param <T>
 * Todos los genericos extienden de BaseDomain
 */
public interface BaseDao<T extends BaseDomain> {
	/**
	 * Almacenar la entidad
	 * @param object
	 */
	void save (T object);
	/**
	 * Actualizar la entidad
	 * @param object
	 */
	void update(T object);
	/**
	 * Borrar la entidad
	 * @param object
	 */
	void delete (T object);
}
