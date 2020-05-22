/**
 * 
 */
package com.orgid.schools.controller;

import com.orgid.schools.exception.AppException;
import com.orgid.schools.model.Role;
import com.orgid.schools.model.RoleName;
import com.orgid.schools.model.User;
import com.orgid.schools.payload.JwtAuthenticationResponse;
import com.orgid.schools.payload.LoginRequest;
import com.orgid.schools.payload.SignUpRequest;
import com.orgid.schools.repository.*;
import com.orgid.schools.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jawahar Dath Thangirala
 * Sep 9, 2019
 */
@SuppressWarnings({"unused"})
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ParentRepository parentRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

	/*//@PostMapping("/signup")
    public ResponseEntity<?> registerUserOld(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
//        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
//                signUpRequest.getEmail(), signUpRequest.getPassword());
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(),
                signUpRequest.getType(), signUpRequest.getLoginid());

        // Validate whether User is either of Student/Teacher/Parent
        String userType = user.getType();
        String loginId  = user.getLoginid();

        Boolean isUserRegistered = false;
        String message = null;
        if(userType != null && "S".equalsIgnoreCase(userType)) {
            isUserRegistered = studentRepository.existsBystudentid(loginId);
            message = "Student Id is not yet registered by Admin.";
        } else if(userType != null && "T".equalsIgnoreCase(userType)) {
            isUserRegistered = teacherRepository.existsByteacherid(loginId);
            message = "Teacher Id is not yet registered by Admin.";
        } else if(userType != null && "P".equalsIgnoreCase(userType)) {
            isUserRegistered = parentRepository.existsByparentid(loginId);
            message = "Parent Id is not yet registered by Admin.";
        }

        if (isUserRegistered) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new AppException("User Role not set."));

            user.setRoles(Collections.singleton(userRole));

            User result = userRepository.save(user);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/api/users/{username}")
                    .buildAndExpand(result.getUsername()).toUri();

            return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
        }


        return ResponseEntity.created(null).body(new ApiResponse(true, message));
    }*/

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        Map<String, Object> response = new HashMap<String, Object>();

        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            response.put("completed", false);
            response.put("httpCode", "200");
            response.put("message", "Username is already taken!");
            response.put("returnValue", null);
            ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            return responseEntity;
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            response.put("completed", false);
            response.put("httpCode", "200");
            response.put("message", "Email Address already in use!");
            response.put("returnValue", null);
            ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            return responseEntity;
        }

        if(userRepository.existsByLoginid(signUpRequest.getLoginid())) {
            response.put("completed", false);
            response.put("httpCode", "200");
            response.put("message", "User has already been registered!");
            response.put("returnValue", null);
            ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            return responseEntity;
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(),
                signUpRequest.getType(), signUpRequest.getLoginid());

        // Validate whether User is either of Student/Teacher/Parent
        String userType = user.getType();
        String loginId  = user.getLoginid();

        Boolean isUserRegistered = false;
        String message = null;
        if(userType != null && "S".equalsIgnoreCase(userType)) {
            isUserRegistered = studentRepository.existsBystudentid(loginId);
            message = "Student Id is not yet registered by Admin.";
        } else if(userType != null && "T".equalsIgnoreCase(userType)) {
            isUserRegistered = teacherRepository.existsByteacherid(loginId);
            message = "Teacher Id is not yet registered by Admin.";
        } else if(userType != null && "P".equalsIgnoreCase(userType)) {
            isUserRegistered = parentRepository.existsByparentid(loginId);
            message = "Parent Id is not yet registered by Admin.";
        }


        if (isUserRegistered) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new AppException("User Role not set."));

            user.setRoles(Collections.singleton(userRole));

            User result = userRepository.save(user);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/api/users/{username}")
                    .buildAndExpand(result.getUsername()).toUri();

            //return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

            response.put("completed", true);
            response.put("httpCode", "200");
            response.put("message", "Ok");
            response.put("returnValue", "User Registerd Successfully");
            ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            return responseEntity;
        }

        response.put("completed", false);
        response.put("httpCode", "200");
        response.put("message", message);
        response.put("returnValue", null);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;

    }
}