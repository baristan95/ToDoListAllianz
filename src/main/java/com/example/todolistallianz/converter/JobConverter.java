package com.example.todolistallianz.converter;

import com.example.todolistallianz.model.dto.JobEntity;
import com.example.todolistallianz.model.request.CreateJobRequest;
import com.example.todolistallianz.model.response.JobResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobConverter {
    public JobResponseDto toJobResponse(JobEntity jobEntity) {
        return JobResponseDto.builder()
                .id(jobEntity.getId())
                .name(jobEntity.getName())
                .description(jobEntity.getDescription())
                .status(jobEntity.getStatus())
                .build();
    }

    public List<JobResponseDto> toJobResponseList(List<JobEntity> jobEntities){
        return jobEntities
                .stream()
                .map(this::toJobResponse)
                .collect(Collectors.toList());
    }

    public JobEntity requestToEntity(CreateJobRequest jobRequest) {
        return JobEntity.builder()
                .name(jobRequest.getName())
                .description(jobRequest.getDescription())
                .status(jobRequest.getStatus())
                .build();
    }
}
