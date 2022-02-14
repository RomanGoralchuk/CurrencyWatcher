package com.currency.crypto.goralchuk.watcher.services;

import com.currency.crypto.goralchuk.watcher.entity.Note;

import java.util.List;

public interface NoteService extends BaseService<Note, Long> {
    List<Note> findByCurrencyId(Long id);
}
