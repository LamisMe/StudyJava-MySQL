package com.example.ss8_validate_thong_tin_bai_hat.service;

import com.example.ss8_validate_thong_tin_bai_hat.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> getAll(Pageable pageable);
    void createSong(Song song);
    void updateSong(Song song);
    Song findById(int id);

}
