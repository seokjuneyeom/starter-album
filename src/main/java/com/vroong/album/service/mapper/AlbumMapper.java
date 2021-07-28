package com.vroong.album.service.mapper;

import com.vroong.album.api.model.AlbumDetailDto;
import com.vroong.album.api.model.AlbumDto;
import com.vroong.album.domain.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        DateTimeMapper.class,
        SongMapper.class,
        SingerMapper.class
})
public interface AlbumMapper extends EntityMapper<AlbumDto, Album>{

    @Override
    @Mapping(source = "id", target = "albumId")
    AlbumDto toDto(Album entity);

    @Mapping(source = "id", target = "albumId")
    AlbumDetailDto toDetailDto(Album entity);

    List<AlbumDetailDto> toDetailDto(List<Album> entityList);
}
