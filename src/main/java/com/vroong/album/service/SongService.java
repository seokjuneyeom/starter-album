package com.vroong.album.service;

import com.vroong.album.api.model.SongDetailDto;
import com.vroong.album.api.model.SongDto;
import com.vroong.album.domain.Song;
import com.vroong.album.repository.SongRepository;
import com.vroong.album.service.mapper.SongMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Transactional
    public SongDto createSong(SongDto dto) {
        Song save = songRepository.save(Song.createFrom(dto));
        return songMapper.toDto(save);
    }

    @Transactional(readOnly = true)
    public SongDetailDto getSong(Long songId) {
        final Song entity = songRepository.findById(songId)
                .orElseThrow(() -> new NoSuchElementException());
        return songMapper.toDetailDto(entity);
    }

}
