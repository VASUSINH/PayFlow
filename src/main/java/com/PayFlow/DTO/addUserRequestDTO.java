package com.PayFlow.DTO;

import lombok.Data;

@Data
public class addUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
