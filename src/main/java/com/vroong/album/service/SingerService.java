package com.vroong.album.service;

import com.vroong.album.domain.Singer;
import com.vroong.album.dto.SingerDto;
import com.vroong.album.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SingerService {
    private final SingerRepository singerRepository;

    @Transactional
    public SingerDto createSinger(Singer singer) {
        Singer save = singerRepository.save(singer);
        return save.toDto();
    }
}
