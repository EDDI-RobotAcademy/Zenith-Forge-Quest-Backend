package com.cafe.backend.common.exception.api;

import com.cafe.backend.sample.service.SampleService;
import com.cafe.backend.sample.service.dto.SampleCreateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionApiTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SampleService sampleService;

    @Test
    @DisplayName("BadRequest 테스트")
    void badRequestTest() throws Exception {
        // given
        SampleCreateRequest sampleCreateRequest = SampleCreateRequest.builder()
                .title("")
                .content("")
                .build();
        // when
        // then
        mockMvc.perform(post("/api/samples")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleCreateRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("NotFound 테스트")
    void notFoundException() throws Exception {
        // given
        SampleCreateRequest sampleCreateRequest = SampleCreateRequest.builder()
                .title("t")
                .content("c")
                .build();
        Long sampleId = sampleService.add(sampleCreateRequest) + 1L;

        // when
        // then
        mockMvc.perform(get("/api/samples/{id}", sampleId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("NotAcceptable 테스트")
    void notAcceptableException() throws Exception {
        // given
        SampleCreateRequest sampleCreateRequest = SampleCreateRequest.builder()
                .title("t")
                .content("c")
                .build();
        Long sampleId = sampleService.add(sampleCreateRequest);
        // when
        // then
        mockMvc.perform(delete("/api/samples/{id}", sampleId))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
}
