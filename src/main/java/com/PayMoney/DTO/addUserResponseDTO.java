package com.PayMoney.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class addUserResponseDTO {
    private Long id;
    private String name;
    private String email;
}
