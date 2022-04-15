package com.example.todolistallianz.persistence.service;

import com.example.todolistallianz.advice.exception.JobNotFoundException;
import com.example.todolistallianz.model.dto.JobEntity;
import com.example.todolistallianz.persistence.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPersistenceService {

    private final JobRepository jobRepository;

    public Optional<JobEntity> findById(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new JobNotFoundException();
        }
        return jobRepository.findById(id);
    }

    public List<JobEntity> findAll() {
        return (List<JobEntity>) jobRepository.findAll();
    }

    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new JobNotFoundException();
        }
        jobRepository.deleteById(id);
    }

    public void save(JobEntity jobEntity) {
        jobRepository.save(jobEntity);
    }
}
