package com.vroong.album.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SingerDto {
    @JsonProperty("singerId")
    private Long singerId;

    @JsonProperty("name")
    private String name;
}

