package com.PayFlow.Service;

import com.PayFlow.DTO.addUserRequestDTO;
import com.PayFlow.DTO.addUserResponseDTO;
import com.PayFlow.Entity.user;
import com.PayFlow.Repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class userService {
    @Autowired
    private userRepository userRepository;

    public addUserResponseDTO createUser(addUserRequestDTO request){

        //As per now Manually Converting RequestDTO object to Entity Object
        //Later Mapper libraries will be used

        user obj = new user();

        obj.setName(request.getName());
        obj.setEmail(request.getEmail());
        obj.setPassword(request.getPassword());

        user savedUser = userRepository.save(obj);

        return new addUserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

}
