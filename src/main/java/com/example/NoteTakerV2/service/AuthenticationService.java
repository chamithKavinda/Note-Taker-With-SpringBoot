package com.example.NoteTakerV2.service;

import com.example.NoteTakerV2.impl.UserDTO;
import com.example.NoteTakerV2.jwtmodels.JwtAuthResponse;
import com.example.NoteTakerV2.jwtmodels.SignIn;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(UserDTO signUp);
    JwtAuthResponse refreshToken(String accessToken);
}
