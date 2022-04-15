package com.example.todolistallianz.service;

import com.example.todolistallianz.converter.JobConverter;
import com.example.todolistallianz.model.dto.JobEntity;
import com.example.todolistallianz.model.request.CreateJobRequest;
import com.example.todolistallianz.model.request.UpdateJobRequest;
import com.example.todolistallianz.model.response.JobResponseDto;
import com.example.todolistallianz.persistence.service.JobPersistenceService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobPersistenceService jobPersistenceService;
    private final JobConverter jobConverter;


    public JobResponseDto findById(Long id) {
        Optional<JobEntity> jobEntityOptional = jobPersistenceService.findById(id);

        return jobConverter.toJobResponse(jobEntityOptional.orElseThrow());
    }

    public List<JobResponseDto> findAll() {
        return jobConverter.toJobResponseList(jobPersistenceService.findAll());
    }

    @Transactional
    public void deleteJob(Long id) {
        jobPersistenceService.deleteJob(id);
    }

    public void updateJob(Long id, UpdateJobRequest request) {
        JobEntity jobEntity = jobPersistenceService.findById(id)
                .orElseThrow();
        if (Objects.nonNull(request.getName())) {
            jobEntity.setName(request.getName());
        }
        if (Objects.nonNull(request.getDescription())) {
            jobEntity.setDescription(request.getDescription());
        }
        if (Objects.nonNull(request.getStatus())) {
            jobEntity.setStatus(request.getStatus());
        }

        jobPersistenceService.save(jobEntity);
    }

    public void createJob(CreateJobRequest createJobRequest) {
        jobPersistenceService.save(jobConverter.requestToEntity(createJobRequest));
    }
}
