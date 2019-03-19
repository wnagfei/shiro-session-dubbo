package com.dao;

import org.hibernate.*;

import com.domain.Userinfo;
import com.utils.HibernateSessionFactory;

import java.util.List;
import java.io.Serializable;

public class BaseDaoHibImpl<T> implements BaseDao<T> {
	// DAO������г־û������ײ�������SessionFactory���
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		//return sessionFactory.getCurrentSession();
		return sessionFactory.openSession();
	}

	// ����ID����ʵ��
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		System.out.println(id);
		return (T) getSession().get(entityClazz, id);
	}

	// ����ʵ��
	public Serializable save(T entity) {
		Session session = getSession();
		Serializable seri = session.save(entity);
		session.flush();
		return seri;
		
	}

	// ����ʵ��
	public void update(T entity) {
		Session session = getSession();
		session.saveOrUpdate(entity);
		session.flush();
	}

	// ɾ��ʵ��
	public void delete(T entity) {
		getSession().delete(entity);
	}

	// ����IDɾ��ʵ��
	public void delete(Class<T> entityClazz, Serializable id,String idkey) {
		getSession()
		.createQuery(
				"delete " + entityClazz.getSimpleName()
						+ " en where en."+idkey+" = "+id)
		.executeUpdate();
	}

	// ��ȡ����ʵ��
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	// ��ȡʵ������
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		// ���ز�ѯ�õ���ʵ������
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	// ����HQL����ѯʵ��
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return (List<T>) getSession().createQuery(hql).list();
	}

	// ���ݴ�ռλ������HQL����ѯʵ��
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... params) {
		// ������ѯ��
		Query query = getSession().createQuery(hql);
		// Ϊ����ռλ����HQL������ò���
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}

	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param pageNo
	 *            ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		// ������ѯ
		return getSession().createQuery(hql)
				// ִ�з�ҳ
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * 
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param params
	 *            ���hql��ռλ��������params���ڴ���ռλ������
	 * @param pageNo
	 *            ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize,
			Object... params) {
		// ������ѯ
		Query query = getSession().createQuery(hql);
		// Ϊ����ռλ����HQL������ò���
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		// ִ�з�ҳ�������ز�ѯ���
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}
	
	//ɾ�����е���������
	public void deleteAll(String tablename) {
		Session session = getSession();
		String sql = "truncate table " + tablename;
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
	}
	
	//�����е�ĳ����������Ϊ��ͬ��ֵ
	public void setFieldValue(String tablename, String field, Object value) {
		String value_str = "";
		//�ж��ǲ���String���͵�
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
