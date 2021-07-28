package com.vroong.album.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AlbumDto {
    @JsonProperty("albumId")
    private Long albumId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("published")
    private OffsetDateTime published;

    public AlbumDto albumId(Long albumId) {
        this.albumId = albumId;
        return this;
    }
}
