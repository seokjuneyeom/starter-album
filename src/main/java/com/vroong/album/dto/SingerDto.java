package com.vroong.album.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Getter
public class SingerDto {
    @JsonProperty("singerId")
    private Long singerId;

    @JsonProperty("name")
    private String name;
}
