package com.softlogia.framework.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.softlogia.framework.domain.Role;
import com.softlogia.framework.domain.User;
import com.softlogia.framework.model.dao.UserDao;
/**
 * 
 * @author Pablo Marquez
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUsers(User usuario) {
		try {
			Criteria criteria = this.getHibernateTemplate().getSessionFactory()
					.openSession().createCriteria(User.class);			
			if (usuario != null) {
				if (usuario.getId() != null) {
					criteria.add(Restrictions.eq("id", usuario.getId()));
				}
				if (usuario.getUser() != null
						&& !usuario.getUser().trim().equals("")) {
					criteria.add(Restrictions.ilike("user",
							usuario.getUser(), MatchMode.ANYWHERE));
				}
				if (usuario.getPassword() != null
						&& !usuario.getPassword().equals("")) {
					criteria.add(Restrictions.eq("password",usuario.getPassword()));
				}
			}
			return (List<User>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersList(Role rol) {
		try {
			if (rol.getId() != null && rol.getName() != null) {
				String sql = "from User user inner join user.roleList rol where rol.id="
						+ rol.getId()
						+ " and upper(rol.nombre) like '"
						+ rol.getName().toUpperCase() + "'";
				return this.getHibernateTemplate().find(sql);
			} else if (rol.getId() != null) {
				String sql = "from User user inner join user.roleList rol where rol.id="
						+ rol.getId();
				return this.getHibernateTemplate().find(sql);
			} else if (rol.getName() != null) {
				String sql = "from User user inner join user.roleList rol where upper(rol.name) like '"
						+ rol.getName().toUpperCase() + "'";
				return this.getHibernateTemplate().find(sql);
			} else {
				String sql = "from User user";
				return this.getHibernateTemplate().find(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
