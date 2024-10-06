package com.example.NoteTakerV2.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String createNoteId(){
        return "NOTE-"+UUID.randomUUID();
    }
    public static String createUserId(){
        return "USER-"+UUID.randomUUID();
    }
    public static String toBase64ProfilePic(MultipartFile profilePic) throws IOException {
        return Base64.getEncoder().encodeToString(profilePic.getBytes());
    }

}
