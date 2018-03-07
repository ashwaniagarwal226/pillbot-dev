package com.pilbot.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pilbot.domain.SaltDO;

@Service("saltInfoService")
@Transactional
public class SaltInfoServiceImpl implements SaltInfoService {
	
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;	
	//protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);	
		this.sessionFactory=sessionFactory;
	}
	
	
	public void saveSaltDetails(SaltDO saltDO) {
		
		try {
			saltDO.getSaltInfoDO().get(0).setSaltDO(saltDO);
			hibernateTemplate.save(saltDO);
		} catch (DataAccessException e) {
			System.out.println(e);
		}
		
	}

	
	public List<SaltDO> getSaltInfo() {
		Session session = sessionFactory.getCurrentSession();
		session.flush();
	    session.clear();
		List<SaltDO>salts=session.createQuery("FROM SaltDO where isActive='Y' order by saltId desc").list();

		return salts;
	}

	
	public void deleteSaltDetails(Integer seletedSaltId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SaltDO salt = (SaltDO)session.get(SaltDO.class, seletedSaltId);
		salt.setIsActive("N");
		hibernateTemplate.saveOrUpdate(salt);
	    tx.commit();
	    session.flush();
	    session.clear();
		//hibernateTemplate.delete(new SaltDO(seletedSaltId));
	}

	
	public SaltDO getSaltInfoById(Integer seletedSaltId) {
		Session session = sessionFactory.getCurrentSession();
		SaltDO salt = (SaltDO)session.get(SaltDO.class, seletedSaltId);
		return salt;
	}

	
	public Boolean updateSaltInfo(SaltDO saltDO) {
		Boolean result=Boolean.FALSE;
		try {
			hibernateTemplate.saveOrUpdate(saltDO);
			result=Boolean.TRUE;
		} catch (DataAccessException e) {
			System.out.println(e);
			result=Boolean.FALSE;
		}
		 catch (Exception e1) {
			 System.out.println(e1);
				result=Boolean.FALSE;
			}
		
		return result;
	}

}
