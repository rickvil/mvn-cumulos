package com.softlogia.framework.model.dao;

import java.util.List;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;
/**
 * 
 * @author Pablo Marquez
 *
 */
public interface RoleDao extends BaseDao<Role> {
	/**
	 * Devuelve la lista de Roles de acuerdo a rol
	 * @param rol
	 * @return
	 */
	public List<Role> searchRoles(Role rol);
	
	/**
	 * Devuelve la lista de Roles de acuerdo a usuario
	 * @param user
	 * @return
	 */
	public List<Role> searchRoles(User user);
}
