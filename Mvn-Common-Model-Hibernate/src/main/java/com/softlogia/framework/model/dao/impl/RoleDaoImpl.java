package com.softlogia.framework.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;
import com.softlogia.framework.model.dao.RoleDao;
/**
 * 
 * @author Pablo Marquez
 *
 */
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> searchRoles(Role rol) {
		try {
			Criteria criteria = this.getHibernateTemplate().getSessionFactory()
					.openSession().createCriteria(Role.class);

			if (rol != null) {
				if (rol.getId() != null) {
					criteria.add(Restrictions.eq("id", rol.getId()));
				}
				if (rol.getName() != null) {
					criteria.add(Restrictions.ilike("nombre", rol.getName(),
							MatchMode.ANYWHERE));
				}
				if (rol.getPermissions() != null) {
					criteria.add(Restrictions.ilike("permisos",
							rol.getPermissions(), MatchMode.ANYWHERE));
				}				
			}
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Role> searchRoles(User user) {
		@SuppressWarnings("unchecked")
		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
		.openSession().createCriteria(Role.class);
		criteria.createAlias("usersList", "user");
		criteria.add(Restrictions.eq("user.id", user.getId()));		
		//List<Role> lista=(List<Role>)getHibernateTemplate().find("from Role rol inner join rol.usersList user where user.id="+user.getId());
		List<Role> lista=criteria.list();
		return lista; 
	}


}
