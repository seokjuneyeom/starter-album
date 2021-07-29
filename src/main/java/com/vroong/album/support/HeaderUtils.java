package com.vroong.album.support;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class HeaderUtils {

  public static URI uri(Object pathParam) {
    return ServletUriComponentsBuilder.fromCurrentRequest().path("/{pathParam}").buildAndExpand(pathParam).toUri();
  }

  private HeaderUtils() {
  }
}
