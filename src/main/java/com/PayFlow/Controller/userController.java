package com.PayFlow.Controller;

import com.PayFlow.DTO.addUserRequestDTO;
import com.PayFlow.DTO.addUserResponseDTO;
import com.PayFlow.DTO.loginRequestDTO;
import com.PayFlow.Service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

     @Autowired
     private userService userService;

    //method return type is addUserResponseDTO as controller classreturns this DTO data.
    //this Line  (@RequestBody addUserRequestDTO add_userdto) creates a DTO Request Object.
    @PostMapping("api/addusers")
    public addUserResponseDTO createUser(@Valid @RequestBody addUserRequestDTO add_userdto){

        return userService.createUser(add_userdto);
    }
    @PostMapping("api/login")
    public addUserResponseDTO login(@RequestBody loginRequestDTO loginRequest) {

        return userService.login(loginRequest);
    }

}
