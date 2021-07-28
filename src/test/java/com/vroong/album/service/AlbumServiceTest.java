package com.vroong.album.service;

import com.vroong.album.ObjectFactory;
import com.vroong.album.api.model.AlbumDto;
import com.vroong.album.api.model.AlbumListDto;
import com.vroong.album.api.model.SingerDto;
import com.vroong.album.api.model.SongDto;
import com.vroong.album.domain.Album;
import com.vroong.album.domain.Singer;
import com.vroong.album.domain.Song;
import com.vroong.album.repository.AlbumRepository;
import com.vroong.album.repository.SingerRepository;
import com.vroong.album.repository.SongRepository;
import com.vroong.album.support.PaginationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AlbumServiceTest {

    @Autowired
    private AlbumService albumService;
    @MockBean
    private AlbumRepository albumRepository;
    @MockBean
    private SongRepository songRepository;
    @MockBean
    private SingerRepository singerRepository;

    @Test
    @DisplayName("앨범 생성 후, 성공")
    void createAlbum() {
        final AlbumDto req = ObjectFactory.getAlbumDto();
        final Album stub = Album.createFrom(req);
        when(albumRepository.save(any())).thenReturn(stub);

        final AlbumDto res = albumService.createAlbum(req);
        assertThat(res.getTitle()).isEqualTo("다시부르기");
    }

    @Test
    @DisplayName("앨범 목록을 불러옴")
    public void testListAlbums() {
        final AlbumDto req = ObjectFactory.getAlbumDto();
        final Album album = Album.createFrom(req);
        Page<Album> stub = new PageImpl<>(Collections.singletonList(album));
        when(albumRepository.findAll(PaginationUtils.getPageable()))
                .thenReturn(stub);

        final AlbumListDto res = albumService.listAlbums(PaginationUtils.getPageable());
        assertThat(res.getData().size()).isEqualTo(1);
        assertThat(res.getData().get(0).getTitle()).isEqualTo("다시부르기");
    }

    @Test
    @DisplayName("앨범과 가수 연결")
    public void testAssociateSinger() {
        when(singerRepository.findById(any()))
                .thenReturn(Optional.of(Singer.createFrom(ObjectFactory.getSingerDto())));
        when(albumRepository.findById(any()))
                .thenReturn(Optional.of(Album.createFrom(ObjectFactory.getAlbumDto())));

        albumService.associateSinger(1L, 1L);
        Optional<Album> album = albumRepository.findById(1L);
        assertSoftly(softAssertions -> {
                    softAssertions.assertThat(album).isNotNull();
                    softAssertions.assertThat(album.get().getSinger().getName()).isEqualTo("김광석");
                }
        );
    }

    @Test
    @DisplayName("앨범과 음악 연결")
    public void testAssociateSong() {
        when(songRepository.findById(any()))
                .thenReturn(Optional.of(Song.createFrom(ObjectFactory.getSongDto())));
        when(albumRepository.findById(any()))
                .thenReturn(Optional.of(Album.createFrom(ObjectFactory.getAlbumDto())));

        albumService.associateSong(1L, 1L);
        Optional<Album> album = albumRepository.findById(1L);
        assertSoftly(softAssertions -> {
                    softAssertions.assertThat(album).isNotNull();
                    softAssertions.assertThat(album.get().getSongs().size()).isEqualTo(1);
                }
        );

    }


}
