package com.example.NoteTakerV2.service;

import com.example.NoteTakerV2.customObj.NoteResponse;
import com.example.NoteTakerV2.impl.NoteDTO;
import org.example.notetaker.customObj.NoteResponse;
import org.example.notetaker.impl.NoteDTO;

import java.util.List;

public interface NoteService{
    void saveNote(NoteDTO noteDTO);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);
    NoteResponse getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
