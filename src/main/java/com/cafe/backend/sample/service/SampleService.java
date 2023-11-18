package com.cafe.backend.sample.service;

import com.cafe.backend.common.exception.custom.NotAcceptableException;
import com.cafe.backend.common.exception.custom.NotFoundException;
import com.cafe.backend.sample.entity.Sample;
import com.cafe.backend.sample.repository.SampleRepository;
import com.cafe.backend.sample.service.dto.SampleCreateRequest;
import com.cafe.backend.sample.service.dto.SampleModifyRequest;
import com.cafe.backend.sample.service.dto.SampleReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;

    public Long add(SampleCreateRequest sampleCreateRequest) {
        return sampleRepository.save(sampleCreateRequest.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public SampleReadResponse get(Long id) {
        Sample sample = getSample(id);

        return SampleReadResponse.of(sample);
    }

    public void modify(Long id, SampleModifyRequest sampleModifyForm) {
        Sample sample = getSample(id);

        sample.update(sampleModifyForm);
    }

    public void remove(Long id) {
        throw new NotAcceptableException("삭제는 허용할 수 없습니다.");
    }

    private Sample getSample(Long id) {
        return sampleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("자원이 없습니다."));
    }
}
