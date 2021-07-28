package com.vroong.album.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vroong.album.support.PageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumListDto {

    @JsonProperty("data")
    @Valid
    private List<AlbumDetailDto> data = null;

    @JsonProperty("page")
    private PageDto page;

    public AlbumListDto data(List<AlbumDetailDto> data) {
        this.data = data;
        return this;
    }

    public AlbumListDto page(PageDto page) {
        this.page = page;
        return this;
    }
}
