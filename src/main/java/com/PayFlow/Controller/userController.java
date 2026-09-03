package com.PayFlow.Controller;

import com.PayFlow.Entity.userEntity;
import com.PayFlow.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

     @Autowired
     private userService userService;


    @PostMapping("api/addusers")
    public userEntity createUser(@RequestBody userEntity user){
        return (userEntity) userService.createUser(user);
    }

}
