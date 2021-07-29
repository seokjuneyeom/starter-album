package com.vroong.album.api;

import com.vroong.album.api.model.SongDetailDto;
import com.vroong.album.api.model.SongDto;
import com.vroong.album.service.SongService;
import com.vroong.album.support.HeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongApiDelegateImpl implements SongApiDelegate {

  private final SongService service;

  @Override
  public ResponseEntity<Void> createSong(SongDto req) {
    final SongDto res = service.createSong(req);
    return ResponseEntity
        .created(HeaderUtils.uri(res.getSongId()))
        .build();
  }

  @Override
  public ResponseEntity<SongDetailDto> getSong(Long songId) {
    SongDetailDto songDto = service.getSong(songId);
    return ResponseEntity.ok(songDto);
  }
}
