package com.orgid.schools.controller;

import com.orgid.schools.security.CurrentUser;
import com.orgid.schools.security.UserPrincipal;
import com.orgid.schools.service.ParentService;
import com.orgid.schools.vo.ParentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
