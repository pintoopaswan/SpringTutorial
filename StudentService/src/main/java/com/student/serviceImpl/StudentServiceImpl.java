package com.student.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.model.StudentDetail;
import com.student.service.StudentService;


/**
 * @author PPaswan
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	final static Logger logger= Logger.getLogger(StudentServiceImpl.class);
	@Autowired
	StudentDao studentDao;
	

	public void registerStudent(StudentDetail studentDetail) {
		logger.info(":: inside register Students's  service ::");
		studentDao.registerStudent(studentDetail);
		
	}

}
