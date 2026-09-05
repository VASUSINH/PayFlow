package com.PayFlow.Service;

import com.PayFlow.DTO.addUserRequestDTO;
import com.PayFlow.DTO.addUserResponseDTO;
import com.PayFlow.Entity.userEntity;
import com.PayFlow.Mapper.userMapper;
import com.PayFlow.Repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class userService {
    @Autowired
    private userRepository userRepository;

    @Autowired
    private userMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public addUserResponseDTO createUser(addUserRequestDTO userRequest) {

        userEntity user = userMapper.toEntity(userRequest);

        user.setPassword(
                passwordEncoder.encode(userRequest.getPassword())
        );

        userEntity savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

}
