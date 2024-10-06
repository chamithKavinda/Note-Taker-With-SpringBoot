package com.example.NoteTakerV2.service;

import com.example.NoteTakerV2.customObj.UserResponse;
import com.example.NoteTakerV2.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    UserResponse getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
}
