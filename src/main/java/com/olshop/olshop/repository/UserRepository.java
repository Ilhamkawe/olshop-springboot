package com.olshop.olshop.repository;


import com.olshop.olshop.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query(value = "SELECT COUNT(u.email) > 0 FROM UserEntity u WHERE u.email = :email")
    Boolean isEmailExist(@Param("email") String email);

    @Query(value = "SELECT COUNT(u.email) > 0 FROM UserEntity u WHERE u.phoneNumber = :phone")
    Boolean isPhoneExist(@Param("phone") String phone);

    @Query(value = "SELECT COUNT(u.username) > 0 FROM UserEntity u WHERE u.username = :username")
    Boolean isUserNameUsed(@Param("username") String username);

    @Query(value = "SELECT u FROM UserEntity u WHERE u.id = :id")
    UserEntity getUserById(@Param("id") int id);

}