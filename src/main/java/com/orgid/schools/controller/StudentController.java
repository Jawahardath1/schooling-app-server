/**
 * 
 */
package com.orgid.schools.controller;

import com.orgid.schools.model.Student;
import com.orgid.schools.security.CurrentUser;
import com.orgid.schools.security.UserPrincipal;
import com.orgid.schools.service.StudentService;
import com.orgid.schools.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jawahar Dath Thangirala
 * Jan 7, 2020
 */
@SuppressWarnings({})
@RestController
@RequestMapping("api/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	   
//	@GetMapping
//	Page<?> getStudents(@PageableDefault Pageable pageable /* (1) */) {
//        Page<Student> students = studentService.findAll(pageable); // (2)
//	    return students;
//	}
	
	/*
	 * @GetMapping public ResponseEntity<?> getStudentList(@CurrentUser
	 * UserPrincipal currentUser) {
	 * 
	 * List<Student> studentList = studentService.findAll();
	 * 
	 * ResponseEntity<?> responseEntity = null; Map<String, Object> response = new
	 * HashMap<String, Object>();
	 * 
	 * response.put("completed", true); response.put("httpCode", "200");
	 * response.put("message", "Ok"); response.put("returnValue", studentList);
	 * 
	 * responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
	 * 
	 * return responseEntity; }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<?> getId(@CurrentUser
	 * UserPrincipal currentUser, @PathVariable Long id) { List<Student> studentList
	 * = studentService.findUserById(id);
	 * 
	 * ResponseEntity<?> responseEntity = null; Map<String, Object> response = new
	 * HashMap<String, Object>();
	 * 
	 * response.put("completed", true); response.put("httpCode", "200");
	 * response.put("message", "Ok"); response.put("returnValue", studentList);
	 * 
	 * responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
	 * 
	 * return responseEntity; }
	 */
	
	/*
	 * @GetMapping("/studentid={id}") public ResponseEntity<?>
	 * getStudentId(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
	 * 
	 * List<Student> studentList = studentService.findUserById(id);
	 * 
	 * ResponseEntity<?> responseEntity = null; Map<String, Object> response = new
	 * HashMap<String, Object>();
	 * 
	 * response.put("completed", true); response.put("httpCode", "200");
	 * response.put("message", "Ok"); response.put("returnValue", studentList);
	 * 
	 * responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
	 * 
	 * return responseEntity; }
	 */
	
	@GetMapping()    
	public Map<String, Object> getStudentInfo(@CurrentUser UserPrincipal currentUser, @RequestBody StudentVo studentVo, @ModelAttribute StudentVo vo) {
		
		List<StudentVo> student = studentService.getStudentInfo(studentVo);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("completed", true);
		response.put("httpCode", "200");
		response.put("message", "Ok");
		response.put("returnValue", student);
		
		return response;
	}
	
	@PostMapping
	public Map<String, Object> insertStudent(@RequestBody Student student) {
		
		Map<String, Object> response = new HashMap<String, Object>();		
		
		// Check if Student Id already exists or not
		if(studentService.existsBystudentid(student.getStudentid())) {
			response.put("completed", false);
			response.put("httpCode", "200");
			response.put("message", "Student Id already exists");		
			response.put("returnValue", null);
			return response;
		}
				
		
		// Insert Student
		Student studentResponse = studentService.insertStudent(student);

		if(studentResponse != null && studentResponse.getId() != null) {
			response.put("returnValue", 1);
		}

		response.put("completed", true);
		response.put("httpCode", "200");
		response.put("message", "Ok");
		// response.put("returnValue", studentResponse);
		return response;
	}
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody StudentVo student, @CurrentUser UserPrincipal currentUser) {
		
		Map<String, Object> response = new HashMap<String, Object>();
    	response.put("completed", true);
		response.put("httpCode", "200");
		response.put("message", "Ok");
		
		// Check if Student Id already exists or not
		if(!studentService.existsBystudentid(student.getStudentid())) {
			response.put("completed", false);
			response.put("httpCode", "200");
			response.put("message", "Student Id does not exist");		
			response.put("returnValue", null);
			ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);	
			return responseEntity;
		}
		
		int studentResponse = studentService.updateStudent(student);		
		response.put("returnValue", studentResponse);
		ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);	
		return responseEntity;
		
		
	}

	//@PreAuthorize("hasRole('USER')")
	
	/*
	 * @PostMapping("/signup") ResponseEntity<?> postCustomers(@Valid @RequestBody
	 * StudentRequest studentRequest, UriComponentsBuilder uriBuilder) {
	 * 
	 * // Check if Student Id already exists or not
	 * if(studentService.existsBystudentid(studentRequest.getStudentid())) { return
	 * new ResponseEntity(new ApiResponse(false, "studentid is already taken!"),
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * // Creating Student Account Student student =
	 * studentService.create(studentRequest); URI location =
	 * uriBuilder.path("api/students/signup/{id}")
	 * .buildAndExpand(student.getId()).toUri(); HttpHeaders headers = new
	 * HttpHeaders(); headers.setLocation(location); return
	 * ResponseEntity.created(location).body(new ApiResponse(true,
	 * "Student registered successfully")); }
	 */
	
	/*
	 * @PostMapping("/signup") ResponseEntity<?> postCustomers(@RequestBody Student
	 * student, UriComponentsBuilder uriBuilder) {
	 * 
	 * // Check if Student Id already exists or not
	 * if(studentService.existsBystudentid(student.getStudentid())) { return new
	 * ResponseEntity(new ApiResponse(false, "studentid is already taken!"),
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * // Creating Student Account Student created = studentService.create(student);
	 * URI location = uriBuilder.path("api/students/signup/{id}")
	 * .buildAndExpand(created.getId()).toUri(); HttpHeaders headers = new
	 * HttpHeaders(); headers.setLocation(location); return
	 * ResponseEntity.created(location).body(new ApiResponse(true,
	 * "Student registered successfully")); }
	 */
	
	
	/*
	 * @PostMapping("/signup") ResponseEntity<Student> postCustomers(@RequestBody
	 * Student student, UriComponentsBuilder uriBuilder) {
	 * 
	 * // Check if Student Id already exists or not
	 * if(studentService.existsBystudentid(student.getStudentid())) { return new
	 * ResponseEntity(new ApiResponse(false, "studentid is already taken!"),
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * // Creating Student Account Student created = studentService.create(student);
	 * URI location = uriBuilder.path("api/students/signup/{id}")
	 * .buildAndExpand(created.getId()).toUri(); HttpHeaders headers = new
	 * HttpHeaders(); headers.setLocation(location); return new
	 * ResponseEntity<>(created, headers, HttpStatus.CREATED); }
	 */
	
}
