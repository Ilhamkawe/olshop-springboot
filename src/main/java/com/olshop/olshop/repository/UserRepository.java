package com.olshop.olshop.repository;


import com.olshop.olshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT u FROM UserEntity  u WHERE u.email = :email")
    UserEntity getUserByEmail(@Param("email") String email);


}
