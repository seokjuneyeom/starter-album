package com.vroong.album.api;

import com.vroong.album.api.model.AlbumDto;
import com.vroong.album.api.model.AlbumListDto;
import com.vroong.album.service.AlbumService;
import com.vroong.album.support.HeaderUtils;
import com.vroong.album.support.PaginationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

  private final AlbumService service;

  @Override
  public ResponseEntity<Void> associateSinger(Long albumId, Long singerId) {
    service.associateSinger(albumId, singerId);
    return null;
  }

  @Override
  public ResponseEntity<Void> associateSong(Long albumId, Long songId) {
    service.associateSong(albumId, songId);
    return null;
  }

  @Override
  public ResponseEntity<Void> createAlbum(AlbumDto req) {
    final AlbumDto res = service.createAlbum(req);
    return ResponseEntity
        .created(HeaderUtils.uri(res.getAlbumId()))
        .build();
  }

  @Override
  public ResponseEntity<AlbumListDto> listAlbums(Integer page, Integer size) {
    final Pageable pageable = PaginationUtils.getPageable(page, size);
    AlbumListDto body = service.listAlbums(pageable);
    return ResponseEntity.ok(body);
  }
}
