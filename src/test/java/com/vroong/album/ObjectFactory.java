package com.vroong.album;

import com.vroong.album.api.model.*;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Collections;

public class ObjectFactory {

    public static AlbumDto getAlbumDto() {
        return new AlbumDto()
                .title("다시부르기")
                .published(OffsetDateTime.parse("1993-03-01T09:00:00+09:00"));
    }

    public static SingerDto getSingerDto() {
        return new SingerDto().name("김광석");
    }

    public static SongDto getSongDto() {
        return new SongDto().title("자동차").playTime("03:20");
    }

    public static SongDetailDto getSongDetail() {
        return new SongDetailDto()
                .songId(1L)
                .title("자동차")
                .playTime("03:20")
                .singer(getSingerDto())
                .album(getAlbumDto());
    }

    public static AlbumDetailDto getAlbumDetail() {
        return new AlbumDetailDto()
                .albumId(1L)
                .title("다시부르기")
                .published(OffsetDateTime.parse("1993-03-01T09:00:00+09:00"))
                .singer(getSingerDto())
                .songs(Collections.singletonList(getSongDto()));
    }
}
