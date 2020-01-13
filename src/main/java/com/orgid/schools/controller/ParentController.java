package com.orgid.schools.controller;

import com.orgid.schools.model.Parent;
import com.orgid.schools.security.CurrentUser;
import com.orgid.schools.security.UserPrincipal;
import com.orgid.schools.service.ParentService;
import com.orgid.schools.vo.ParentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping
    public ResponseEntity<?> getTeacher(@CurrentUser UserPrincipal currentUser, @RequestBody ParentVo vo) {

        List<ParentVo> parentResponse = parentService.getParent(vo);

//		String userName = currentUser.getUsername();
//		Long   id 		= currentUser.getId();
//		String password = currentUser.getPassword();
//		String message = "userName: " + userName + " password: " + password;

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("completed", true);
        response.put("httpCode", "200");
        response.put("message", "Ok");
        response.put("returnValue", parentResponse);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping
    public Map<String, Object> insertParent(@CurrentUser UserPrincipal currentUser, @RequestBody Parent parent) {

        Map<String, Object> response = new HashMap<String, Object>();

        // Check if Parent Id already exists or not
        if(parentService.existsByparentrid(parent.getParentid())) {
            response.put("completed", false);
            response.put("httpCode", "200");
            response.put("message", "Teacher Id already exists");
            response.put("returnValue", null);
            return response;
        }

        parent.setCreatedBy(currentUser.getId());
        parent.setUpdatedBy(currentUser.getId());

        // Insert Parent
        Parent parentResponse = parentService.insertParent(parent);

        if(parentResponse != null && parentResponse.getId() != null) {
            response.put("returnValue", 1);
        }

        response.put("completed", true);
        response.put("httpCode", "200");
        response.put("message", "Ok");
        return response;
    }

    @PutMapping
    public ResponseEntity<?> updateParent(@RequestBody ParentVo vo, @CurrentUser UserPrincipal currentUser) {

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("completed", true);
        response.put("httpCode", "200");
        response.put("message", "Ok");

        // Check if Student Id already exists or not
        if(!parentService.existsByparentrid(vo.getParentid())) {
            response.put("completed", false);
            response.put("httpCode", "200");
            response.put("message", "Teacher Id does not exist");
            response.put("returnValue", null);
            ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            return responseEntity;
        }

        int parentResponse = parentService.updateParent(vo);
        response.put("returnValue", parentResponse);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;


    }
}
