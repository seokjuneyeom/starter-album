package com.vroong.album.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vroong.album.api.model.SingerDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "singer")
    private Set<Album> albums = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "singer")
    private Set<Song> songs = new HashSet<>();

    @Builder
    public Singer(String name) {
        this.name = name;
    }

    public static Singer createFrom(SingerDto dto) {
        return new Singer(dto.getName());
    }

    public void addAlbum(Album album) {
        if (!this.albums.contains(album)) {
            this.albums.add(album);
        }
    }

    public void addSong(Song song) {
        if (!this.songs.contains(song)) {
            this.songs.add(song);
        }
    }

}
