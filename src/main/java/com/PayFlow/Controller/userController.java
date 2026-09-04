package com.PayFlow.Controller;

import com.PayFlow.DTO.addUserRequestDTO;
import com.PayFlow.DTO.addUserResponseDTO;
import com.PayFlow.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

     @Autowired
     private userService userService;

    //method return type is addUserResponseDTO as controller classreturns this DTO data.
    @PostMapping("api/addusers")
    public addUserResponseDTO createUser(@RequestBody addUserRequestDTO add_userdto){

        return userService.createUser(add_userdto);
    }

}
