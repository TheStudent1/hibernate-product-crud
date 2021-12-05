package com.app.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.models.Product;
import com.hibernate.utils.HibernateUtils;

public class ProductDAOImpl implements IDAO<Product> {

	Logger lg = Logger.getLogger(ProductDAOImpl.class);

	@Override
	public boolean create(Product e) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			lg.info("saving traitment start ...!");

			s.save(e);
			t.commit();

			lg.info("saving successfully ...!");
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return false;
	}

	@Override
	public Product getOne(Long id) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			lg.info("get One traitment start ...!");
			Product p = new Product();

			p = s.get(Product.class, id);
			t.commit();

			lg.info("get One successfully ...!");
			return p;
		} catch (Exception e2) {
			e2.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return null;
	}

	@Override
	public boolean update(Product e) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			lg.info("Update traitment start ...!");

			s.update(e);
			t.commit();

			lg.info("Updated successfully ...!");
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return false;
	}

	@Override
	public boolean delete(Product e) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			lg.info("Delete traitment start ...!");

			s.delete(e);
			t.commit();

			lg.info("Delete successfully ...!");
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return false;
	}

	@Override
	public List<Product> getAll() {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			lg.info("Get All traitment Begin ...!");
			List<Product> prdcts = new ArrayList<Product>();

			prdcts = s.getNamedQuery("getAll").getResultList();
			t.commit();

			lg.info("Get All Successfully ...!");
			return prdcts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}

		return null;
	}

	@Override
	public List<Product> getAll(String mc) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			lg.info("Get All traitment Begin ...!");
			List<Product> prdcts = new ArrayList<Product>();

			prdcts = s.getNamedQuery("getByMc").setParameter("name", "%" + mc + "%").getResultList();
			t.commit();

			lg.info("Get All Successfully ...!");
			return prdcts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}

		return null;
	}

}
