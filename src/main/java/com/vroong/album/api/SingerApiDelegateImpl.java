package com.vroong.album.api;

import com.vroong.album.api.model.SingerDto;
import com.vroong.album.service.SingerService;
import com.vroong.album.support.HeaderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingerApiDelegateImpl implements SingerApiDelegate {

  private final SingerService service;

  @Override
  public ResponseEntity<Void> createSinger(SingerDto req) {
    final SingerDto res = service.createSinger(req);
    return ResponseEntity
        .created(HeaderUtils.uri(res.getSingerId()))
        .build();
  }
}
