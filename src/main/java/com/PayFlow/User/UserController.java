package com.PayFlow.User;

import com.PayFlow.User.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("api/addusers")
    public User createUser(@RequestBody User user){
        return (User) userService.createUser(user);
    }

}
