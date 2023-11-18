package com.cafe.backend.common.exception.unit;


import com.cafe.backend.common.exception.custom.NotAcceptableException;
import com.cafe.backend.common.exception.custom.NotFoundException;
import com.cafe.backend.sample.service.SampleService;
import com.cafe.backend.sample.service.dto.SampleCreateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExceptionUnitTest {

    @Autowired
    SampleService sampleService;

    @Test
    @DisplayName("NotFound 테스트")
    void notFoundException(){
        // given
        SampleCreateRequest sampleCreateRequest = SampleCreateRequest.builder()
                .title("제목")
                .content("내용")
                .build();
        Long sampleId = sampleService.add(sampleCreateRequest) + 1L;
        // when
        // then
        Assertions.assertThrows(NotFoundException.class, () -> {
            sampleService.get(sampleId);
        });
    }

    @Test
    @DisplayName("NotAcceptable 테스트")
    void notAcceptableException(){
        // given
        SampleCreateRequest sampleCreateRequest = SampleCreateRequest.builder()
                .title("제목")
                .content("내용")
                .build();
        Long sampleId = sampleService.add(sampleCreateRequest);
        // when
        // then
        Assertions.assertThrows(NotAcceptableException.class, () -> {
            sampleService.remove(sampleId);
        });
    }
}
