package com.vroong.album.service;

import com.vroong.album.domain.Album;
import com.vroong.album.dto.AlbumDto;
import com.vroong.album.repository.AlbumRepository;
import com.vroong.album.repository.SingerRepository;
import com.vroong.album.repository.SongRepository;
import com.vroong.album.support.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final SingerRepository singerRepository;

    @Transactional
    public AlbumDto createAlbum(AlbumDto albumDto) {
        Album entity = Album.createFrom(albumDto);
        albumRepository.save(entity);
        return entity.toDto();
    }

    @Transactional
    public void associateSong(Long albumId, Long songId) {
        songRepository.findById(songId).ifPresent(song -> {
            albumRepository.findById(albumId).ifPresent(album -> {
                song.associateAlbum(album);
            });
        });
    }

    @Transactional
    public void associateSinger(Long albumId, Long singerId) {
        singerRepository.findById(singerId).ifPresent(singer -> {
            albumRepository.findById(albumId).ifPresent(album -> {
                album.associateSinger(singer);
            });
        });
    }

    @Transactional(readOnly = true)
    public AlbumListDto listAlbums(Pageable pageable) {
        final Page<Album> page = albumRepository.findAll(pageable);
        return new AlbumListDto()
                .data(convertDtoList(page.getContent()))
                .page(PaginationUtils.getPageDto(page));
    }

    private List<AlbumDetailDto> convertDtoList(List<Album> content) {
     return content.stream().map(album -> album.toDetailDto()
        ).collect(Collectors.toList());
    }
}
