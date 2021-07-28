package com.vroong.album.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vroong.album.config.Constants;
import com.vroong.album.dto.AlbumDto;
import com.vroong.album.service.AlbumDetailDto;
import com.vroong.album.support.Carbon;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Instant published;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    @JsonBackReference
    private Singer singer;

    @OneToMany(mappedBy = "album")
    @JsonManagedReference
    private Set<Song> songs = new HashSet<>();

    @Builder
    public Album(String title) {
        this.title = title;
    }

    public static Album createForm(AlbumDto dto) {
        Album album = new Album(dto.getTitle());
        final Instant published = Carbon.from(dto.getPublished(), ZoneId.of(Constants.TIMEZONE_SEOUL)).toInstant();
        album.markPublished(published);
        return album;
    }

    public static Album createFrom(AlbumDto dto) {
        Album album = new Album(dto.getTitle());
        final Instant published = Carbon.from(dto.getPublished(), ZoneId.of(Constants.TIMEZONE_SEOUL)).toInstant();
        album.markPublished(published);
        return album;
    }

    public void associateSinger(Singer singer) {
        this.singer = singer;
        this.singer.addAlbum(this);
    }

    public void addSong(Song song) {
        if (!this.songs.contains(song)) {
            this.songs.add(song);
        }
    }

    public void markPublished() {
        this.published = Instant.now();
    }

    public void markPublished(Instant publishedDate) {
        this.published = publishedDate;
    }

    public AlbumDetailDto toDetailDto() {
        return AlbumDetailDto.builder()
                .albumId(this.id)
                .title(this.title)
                .published(this.published.atOffset(ZoneOffset.UTC))
                .singer(this.singer != null ? this.singer.toDto() : null)
                .songs(this.songs.isEmpty() ? null : this.songs.stream().map(v -> v.toDto()).collect(Collectors.toList())).build();
    }

    public AlbumDto toDto() {
        return AlbumDto.builder()
                .albumId(this.id)
                .published(Carbon.from(this.published, ZoneId.of(Constants.TIMEZONE_SEOUL)).toOffsetDateTime())
                .title(this.title)
                .build();
    }
}
