package com.PayMoney.Service;

import com.PayMoney.DTO.addUserRequestDTO;
import com.PayMoney.DTO.addUserResponseDTO;
import com.PayMoney.DTO.loginRequestDTO;
import com.PayMoney.Entity.userEntity;
import com.PayMoney.Mapper.userMapper;
import com.PayMoney.Repository.userRepository;
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
    public addUserResponseDTO login(loginRequestDTO loginRequest) {

        userEntity user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        boolean passwordMatches = passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid email or password");
        }

        return userMapper.toResponse(user);
    }

}
