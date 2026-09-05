package com.PayFlow.Service;

import com.PayFlow.DTO.addUserRequestDTO;
import com.PayFlow.DTO.addUserResponseDTO;
import com.PayFlow.Entity.user;
import com.PayFlow.Mapper.userMapper;
import com.PayFlow.Repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class userService {
    @Autowired
    private userRepository userRepository;

    @Autowired
    private userMapper userMapper;

    public addUserResponseDTO createUser(addUserRequestDTO userRequest) {

        user user = userMapper.toEntity(userRequest);

        user savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

}
