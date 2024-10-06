package com.example.NoteTakerV2.dao;

import com.example.NoteTakerV2.entity.UserEntity;
import org.example.notetaker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity getUserEntityByUserId(String userId);
}
