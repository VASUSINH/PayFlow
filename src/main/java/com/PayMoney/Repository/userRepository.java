package com.PayMoney.Repository;

import com.PayMoney.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface userRepository extends JpaRepository<userEntity,Long> {

    Optional<userEntity> findByEmail(String email);


}
