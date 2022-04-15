package com.example.todolistallianz.persistence.repository;

import com.example.todolistallianz.model.dto.JobEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface JobRepository extends PagingAndSortingRepository <JobEntity, Long> {

    Optional<JobEntity> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);
}
