package com.student.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.model.StudentDetail;
import com.student.service.StudentService;

/**
 * @author PPaswan
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	final static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	StudentService StudentService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public long registerStudent(@RequestBody StudentDetail studentDetail,HttpServletRequest request, HttpServletResponse response){
		logger.debug("User Registration Started for : " + studentDetail.getName());
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		try{ 
			StudentService.registerStudent(studentDetail);
			
		}catch(Exception e){
			System.out.println("Exception occured:"+e.getMessage());
			
		}

		return studentDetail.getId();
		
	}


}
