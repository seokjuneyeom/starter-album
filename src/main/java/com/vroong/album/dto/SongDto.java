package com.vroong.album.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
public class SongDto {

    @JsonProperty("songId")
    private Long songId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("playTime")
    private String playTime;

    public SongDto songId(Long songId) {
        this.songId = songId;
        return this;
    }
}
