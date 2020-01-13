/**
 * 
 */
package com.orgid.schools.controller;

import com.orgid.schools.model.Teacher;
import com.orgid.schools.security.CurrentUser;
import com.orgid.schools.security.UserPrincipal;
import com.orgid.schools.service.TeacherService;
import com.orgid.schools.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jawahar Dath Thangirala
 * Jan 10, 2020
 */
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@GetMapping
	public ResponseEntity<?> getTeacher(@CurrentUser UserPrincipal currentUser, @RequestBody TeacherVo teacherVo) {
		
		List<TeacherVo> teacherResponse = teacherService.getTeacher(teacherVo);
				
//		String userName = currentUser.getUsername();
//		Long   id 		= currentUser.getId();
//		String password = currentUser.getPassword();		
//		String message = "userName: " + userName + " password: " + password;
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("completed", true);
		response.put("httpCode", "200");
		response.put("message", "Ok");		
		response.put("returnValue", teacherResponse);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);	
		return responseEntity;
		
	}
	
	@PostMapping
	public Map<String, Object> insertTeacher(@CurrentUser UserPrincipal currentUser, @RequestBody Teacher teacher) {
		
		Map<String, Object> response = new HashMap<String, Object>();		
		
		// Check if Teacher Id already exists or not
		if(teacherService.existsByteacherid(teacher.getTeacherid())) {
			response.put("completed", false);
			response.put("httpCode", "200");
			response.put("message", "Teacher Id already exists");		
			response.put("returnValue", null);
			return response;
		}
		
		teacher.setCreatedBy(currentUser.getId());
		teacher.setUpdatedBy(currentUser.getId());
						
		// Insert Teacher
		Teacher teacherResponse = teacherService.insertTeacher(teacher);

		if(teacherResponse != null && teacherResponse.getId() != null) {
			response.put("returnValue", 1);
		}

		response.put("completed", true);
		response.put("httpCode", "200");
		response.put("message", "Ok");
		return response;
	}

	@PutMapping
	public ResponseEntity<?> updateTeacher(@RequestBody TeacherVo vo, @CurrentUser UserPrincipal currentUser) {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("completed", true);
		response.put("httpCode", "200");
		response.put("message", "Ok");

		// Check if Student Id already exists or not
		if(!teacherService.existsByteacherid(vo.getTeacherid())) {
			response.put("completed", false);
			response.put("httpCode", "200");
			response.put("message", "Teacher Id does not exist");
			response.put("returnValue", null);
			ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			return responseEntity;
		}

		int parentResponse = teacherService.updateTeacher(vo);
		response.put("returnValue", parentResponse);
		ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		return responseEntity;


	}

}
