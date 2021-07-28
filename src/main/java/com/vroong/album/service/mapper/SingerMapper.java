package com.vroong.album.service.mapper;

import com.vroong.album.api.model.SingerDto;
import com.vroong.album.domain.Singer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SingerMapper extends EntityMapper<SingerDto, Singer> {

    @Override
    @Mapping(source = "id", target = "singerId")
    SingerDto toDto(Singer entity);
}

