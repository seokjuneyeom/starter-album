package com.vroong.album;

import com.vroong.album.api.model.AlbumDto;
import com.vroong.album.api.model.SingerDto;
import com.vroong.album.api.model.SongDto;

import java.time.OffsetDateTime;

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
}
