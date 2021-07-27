package com.vroong.album.service;

import com.vroong.album.domain.Singer;
import com.vroong.album.dto.SingerDto;
import com.vroong.album.repository.SingerRepository;
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
public class SingerServiceTest {

    @Autowired
    private SingerService singerService;

    @MockBean
    private SingerRepository singerRepository;

    @Test
    @DisplayName("가수를 생성하면, 성공")
    void 가수생성_성공() {

        Singer singer = Singer.builder().name("김가수").build();
        when(singerRepository.save(any())).thenReturn(singer);

        SingerDto dto = singerService.createSinger(singer);

        assertSoftly(softly -> {
            assertThat(dto).isNotNull();
            assertThat(dto.getName()).isEqualTo("김가수");
        });

    }
}
