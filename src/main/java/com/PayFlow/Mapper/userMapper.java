package com.PayFlow.Mapper;

import com.PayFlow.DTO.addUserRequestDTO;
import com.PayFlow.DTO.addUserResponseDTO;
import com.PayFlow.Entity.user;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class userMapper {
        //This Function converts DTO Request object to Entity Object.
        public user toEntity(addUserRequestDTO userRequest) {

            user user = new user();

            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());

            return user;
        }
       //This function converts Entity object to DTO Response Object.
        public addUserResponseDTO toResponse(user user) {

            return new addUserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail()
            );
        }

}
