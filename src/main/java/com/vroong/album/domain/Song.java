package com.vroong.album.domain;

import com.vroong.album.api.model.SongDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String playTime;

    @ManyToOne
    private Singer singer;

    @ManyToOne
    private Album album;

    @Builder
    public Song(String title, String playTime) {
        this.title = title;
        this.playTime = playTime;
    }

    public static Song createFrom(SongDto dto) {
        return new Song(dto.getTitle(), dto.getPlayTime());
    }

    public void associateAlbum(Album album) {
        this.album = album;
        album.addSong(this);
    }

    public void associateSinger(Singer singer) {
        this.singer = singer;
        singer.addSong(this);
    }
}
