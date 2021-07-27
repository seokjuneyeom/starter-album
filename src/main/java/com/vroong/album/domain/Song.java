package com.vroong.album.domain;

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

    @Builder
    public Song(String title, String playTime) {
        this.title = title;
        this.playTime = playTime;
    }
}
