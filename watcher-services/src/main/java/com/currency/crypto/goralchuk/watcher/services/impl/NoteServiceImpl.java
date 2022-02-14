package com.currency.crypto.goralchuk.watcher.services.impl;

import com.currency.crypto.goralchuk.watcher.dao.NoteRepository;
import com.currency.crypto.goralchuk.watcher.entity.Note;
import com.currency.crypto.goralchuk.watcher.services.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note saveOrUpdate(Note entity) {
        return noteRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> findByCurrencyId(Long id) {
        return noteRepository.findByCurrencyId(id);
    }
}
