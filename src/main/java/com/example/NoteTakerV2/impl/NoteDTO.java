package com.example.NoteTakerV2.impl;

import com.example.NoteTakerV2.customObj.NoteResponse;
import com.example.NoteTakerV2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notetaker.customObj.NoteResponse;
import org.example.notetaker.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
