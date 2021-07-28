package com.vroong.album.service;

import com.vroong.album.domain.Song;
import com.vroong.album.dto.SongDto;
import com.vroong.album.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    @Transactional
    public SongDto createSong(SongDto dto) {
        Song song = Song.createFrom(dto);
        Song save = songRepository.save(song);
        return save.toDto();
    }

}
