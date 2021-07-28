package com.vroong.album.service;

import com.vroong.album.domain.Song;
import com.vroong.album.dto.SongDto;
import com.vroong.album.repository.SongRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SongServiceTest {

    @Autowired
    private SongService songService;

    @MockBean private SongRepository songRepository;

    @Test
    @DisplayName("음악을 생성하면, 성공")
    void 음악생성() {
        Song song = Song.builder().title("자동차").playTime("03:20").build();
        when(songRepository.save(any())).thenReturn(song);

        SongDto dto = songService.createSong(SongDto.builder().title("자동차").playTime("03:20").build());
        assertSoftly(softly -> {
            assertThat(dto).isNotNull();
            assertThat(dto.getTitle()).isEqualTo("자동차");
        });
    }
}
