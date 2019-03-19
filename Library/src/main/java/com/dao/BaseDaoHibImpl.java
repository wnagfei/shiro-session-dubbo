package com.dao;

import org.hibernate.*;

import com.domain.Userinfo;
import com.utils.HibernateSessionFactory;

import java.util.List;
import java.io.Serializable;

public class BaseDaoHibImpl<T> implements BaseDao<T> {
	// DAO组件进行持久化操作底层依赖的SessionFactory组件
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		//return sessionFactory.getCurrentSession();
		return sessionFactory.openSession();
	}

	// 根据ID加载实体
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		System.out.println(id);
		return (T) getSession().get(entityClazz, id);
	}

	// 保存实体
	public Serializable save(T entity) {
		Session session = getSession();
		Serializable seri = session.save(entity);
		session.flush();
		return seri;
		
	}

	// 更新实体
	public void update(T entity) {
		Session session = getSession();
		session.saveOrUpdate(entity);
		session.flush();
	}

	// 删除实体
	public void delete(T entity) {
		getSession().delete(entity);
	}

	// 根据ID删除实体
	public void delete(Class<T> entityClazz, Serializable id,String idkey) {
		getSession()
		.createQuery(
				"delete " + entityClazz.getSimpleName()
						+ " en where en."+idkey+" = "+id)
		.executeUpdate();
	}

	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	// 获取实体总数
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	// 根据HQL语句查询实体
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return (List<T>) getSession().createQuery(hql).list();
	}

	// 根据带占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... params) {
		// 创建查询
		Query query = getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		// 创建查询
		return getSession().createQuery(hql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param params
	 *            如果hql带占位符参数，params用于传入占位符参数
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize,
			Object... params) {
		// 创建查询
		Query query = getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}
	
	//删除表中的所有数据
	public void deleteAll(String tablename) {
		Session session = getSession();
		String sql = "truncate table " + tablename;
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
	}
	
	//将表中的某个属性设置为相同的值
	public void setFieldValue(String tablename, String field, Object value) {
		String value_str = "";
		//判断是不是String类型的
		if(value instanceof String) {
			value_str = "\""+value+"\"";
		}else {
			value_str = value.toString();
		}
		String sql = "update "+tablename +" set "+field +"="+value_str;
		Query query = getSession().createSQLQuery(sql);
		query.executeUpdate();
	}
}
