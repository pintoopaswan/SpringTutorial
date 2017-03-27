package com.student.daoImpl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.StudentDao;
import com.student.model.StudentDetail;

/**
 * @author PPaswan
 *
 */

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	final static Logger lOGGER= Logger.getLogger(StudentDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public void registerStudent(StudentDetail studentDetail) {
		try{
			sessionFactory.getCurrentSession().save(studentDetail);
			lOGGER.info("::student registered with id:"+studentDetail.getId());
		}catch(Exception e){
			System.out.println("Server Error:"+e.getMessage());
			lOGGER.error("::student registration failed:",e);
		}
		
	}

}
