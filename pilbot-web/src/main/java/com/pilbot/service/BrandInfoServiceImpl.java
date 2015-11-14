package com.pilbot.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pilbot.domain.SaltBrandDO;

@Service("brandInfoService")
@Transactional
public class BrandInfoServiceImpl implements BrandInfoService {
	
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;	
	//protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);	
		this.sessionFactory=sessionFactory;
	}

	
	public Boolean saveBrandDetails(SaltBrandDO brandDO) {
		Boolean result=Boolean.FALSE;
		try {
			brandDO.setIsActive("Y");
			hibernateTemplate.save(brandDO);
			result=Boolean.TRUE;
		} catch (DataAccessException e) {
			System.out.println(e);
			result=Boolean.FALSE;
		}
		
		return result;
	}

	
	public List<SaltBrandDO> getSaltBrandInfo() {
		Session session = sessionFactory.getCurrentSession();
		session.flush();
	    session.clear();
		List<SaltBrandDO>saltsBrand=session.createQuery("FROM SaltBrandDO where isActive='Y'  order by 1 desc").list();
		return saltsBrand;
	}

	
	public Boolean deleteBrandDetails(Integer seletedSaltId) {
		Boolean result=Boolean.FALSE;
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			SaltBrandDO brand = (SaltBrandDO)session.get(SaltBrandDO.class, seletedSaltId);
			brand.setIsActive("N");
			hibernateTemplate.saveOrUpdate(brand);
			tx.commit();
			result=Boolean.TRUE;
			session.flush();
			session.clear();
		} catch (HibernateException e) {
			result=Boolean.FALSE;
			System.out.println(e);
		} catch (DataAccessException e) {
			System.out.println(e);
			result=Boolean.FALSE;
		}
	return result;	
	}

	
	public SaltBrandDO getBrandInfoById(Integer seletedBrandId) {
		
		SaltBrandDO brand=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			brand = (SaltBrandDO)session.get(SaltBrandDO.class, seletedBrandId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return brand;
	}

	
	public Boolean updateBrandInfo(SaltBrandDO brandDO) {
		Boolean result=Boolean.FALSE;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			hibernateTemplate.saveOrUpdate(brandDO);
			tx.commit();
			result=Boolean.TRUE;
			session.flush();
			session.clear();
		} catch (HibernateException e) {
			result=Boolean.FALSE;
			e.printStackTrace();
		} catch (DataAccessException e) {
			result=Boolean.FALSE;
			e.printStackTrace();
		}
		
		return result;
	}

}
