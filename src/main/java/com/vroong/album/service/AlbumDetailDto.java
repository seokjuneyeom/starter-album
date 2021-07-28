package com.vroong.album.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vroong.album.dto.SingerDto;
import com.vroong.album.dto.SongDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AlbumDetailDto {
    @JsonProperty("albumId")
    private Long albumId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("published")
    private OffsetDateTime published;

    @JsonProperty("singer")
    private SingerDto singer;

    @JsonProperty("songs")
    @Valid
    private List<SongDto> songs = null;

    public AlbumDetailDto albumId(Long albumId) {
        this.albumId = albumId;
        return this;
    }
}
