package com.vroong.album.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PageDto {
    @JsonProperty("size")
    private Integer size = 20;

    @JsonProperty("totalElements")
    private Long totalElements;

    @JsonProperty("totalPages")
    private Integer totalPages;

    @JsonProperty("number")
    private Integer number = 1;

    public PageDto size(Integer size) {
        this.size = size;
        return this;
    }

    public PageDto number(Integer number) {
        this.number = number;
        return this;
    }

    public PageDto totalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public PageDto totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }
}
