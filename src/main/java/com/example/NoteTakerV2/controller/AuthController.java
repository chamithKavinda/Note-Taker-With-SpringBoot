package com.example.NoteTakerV2.controller;

import com.example.NoteTakerV2.exception.DataPersistFailedException;
import com.example.NoteTakerV2.impl.UserDTO;
import com.example.NoteTakerV2.jwtmodels.JWTResponse;
import com.example.NoteTakerV2.jwtmodels.JwtAuthResponse;
import com.example.NoteTakerV2.jwtmodels.SignIn;
import com.example.NoteTakerV2.service.AuthenticationService;
import com.example.NoteTakerV2.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "signup",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JwtAuthResponse> signUp(
            @RequestPart("firstName") String firstName,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilePic") MultipartFile profilePic,
            @RequestPart ("Role") String role) { {
        try {
            String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
            UserDTO buildUserDTO = new UserDTO();
            buildUserDTO.setUserId(AppUtil.createUserId());
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(passwordEncoder.encode(password));
            buildUserDTO.setProfilePic(base64ProfilePic);
            //send to the service layer
            return ResponseEntity.ok(authenticationService.signUp(buildUserDTO));
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "signin")
        public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signIn) {
            return ResponseEntity.ok(authenticationService.signIn(signIn));
        }
        @PostMapping("refresh")
        public ResponseEntity<JwtAuthResponse> refreshToken (@RequestParam ("refreshToken") String refreshToken){
            return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
        }
    }
}
