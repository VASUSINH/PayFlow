package com.PayFlow.Service;

import com.PayFlow.Entity.userEntity;
import com.PayFlow.Repository.userRepository;
import org.springframework.stereotype.Service;

@Service
public class userService {
    private final userRepository userRepository;

    public userService(userRepository userRepository) {
        this.userRepository = userRepository;

    }
    public userEntity createUser(userEntity user){
        return userRepository.save(user);
    }

}
