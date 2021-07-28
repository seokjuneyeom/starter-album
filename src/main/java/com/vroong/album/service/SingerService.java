package com.vroong.album.service;

import com.vroong.album.api.model.SingerDto;
import com.vroong.album.domain.Singer;
import com.vroong.album.repository.SingerRepository;
import com.vroong.album.service.mapper.SingerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SingerService {
    private final SingerRepository singerRepository;
    private final SingerMapper singerMapper;

    @Transactional
    public SingerDto createSinger(SingerDto dto) {
        Singer save = singerRepository.save(Singer.createFrom(dto));
        return singerMapper.toDto(save);
    }
}
