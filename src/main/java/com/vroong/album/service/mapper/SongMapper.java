package com.vroong.album.service.mapper;

import com.vroong.album.api.model.SongDetailDto;
import com.vroong.album.api.model.SongDto;
import com.vroong.album.domain.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SingerMapper.class, AlbumMapper.class})
public interface SongMapper extends EntityMapper<SongDto, Song> {

    @Override
    @Mapping(source = "id", target = "songId")
    SongDto toDto(Song entity);

    @Mapping(source = "id", target = "songId")
    SongDetailDto toDetailDto(Song entity);
}