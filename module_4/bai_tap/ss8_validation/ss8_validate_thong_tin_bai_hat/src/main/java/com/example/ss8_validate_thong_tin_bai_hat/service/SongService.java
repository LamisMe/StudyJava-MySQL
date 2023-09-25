package com.example.ss8_validate_thong_tin_bai_hat.service;

import com.example.ss8_validate_thong_tin_bai_hat.model.Song;
import com.example.ss8_validate_thong_tin_bai_hat.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> getAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public void createSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }
}
