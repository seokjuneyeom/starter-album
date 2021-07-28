package com.vroong.album.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vroong.album.dto.SingerDto;
import lombok.*;

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

    public SingerDto toDto() {
        return SingerDto.builder().name(this.name).singerId(this.id).build();
    }
}
