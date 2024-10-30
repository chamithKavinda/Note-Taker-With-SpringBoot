package com.example.NoteTakerV2.controller;

import com.example.NoteTakerV2.exception.DataPersistFailedException;
import com.example.NoteTakerV2.impl.UserDTO;
import com.example.NoteTakerV2.jwtmodels.JWTResponse;
import com.example.NoteTakerV2.jwtmodels.SignIn;
import com.example.NoteTakerV2.util.AppUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping(value = "signup")
    public ResponseEntity<JWTResponse> signUp(){
        return null;
    }
    @PostMapping(value = "signin")
    public ResponseEntity<JWTResponse> signIn(){
        return null;
    }
}
