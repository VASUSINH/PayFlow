package com.PayFlow.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class userEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String email;
    private String password;

}
