package com.example.todolistallianz.controller;

import com.example.todolistallianz.model.request.CreateJobRequest;
import com.example.todolistallianz.model.request.UpdateJobRequest;
import com.example.todolistallianz.model.response.JobResponseDto;
import com.example.todolistallianz.service.JobService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.todolistallianz.validator.JobValidator.validateJobCreateRequest;
import static com.example.todolistallianz.validator.JobValidator.validateJobUpdateRequest;


@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @ApiOperation(value = "Finding a Job with ID.", notes = "The job is found with the ID you entered.")
    @GetMapping("/{id}")
    public JobResponseDto findJobById(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @ApiOperation(value = "Find all Jobs.", notes = "All jobs are listed.")
    @GetMapping()
    public List<JobResponseDto> findAll() {
        return jobService.findAll();
    }

    @ApiOperation(value = "Delete a Job with ID.", notes = "The job is deleted with the ID you entered.")
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    @ApiOperation(value = "Create a new Job.", notes = "The job is created with the text you entered.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createJob(@Valid @RequestBody CreateJobRequest jobRequest) {
        validateJobCreateRequest(jobRequest);
        jobService.createJob(jobRequest);
    }

    @ApiOperation(value = "Update a Job with ID.", notes = "The job is updated with the ID you entered.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateJob(@PathVariable Long id, @RequestBody UpdateJobRequest updateJobRequest) {
        validateJobUpdateRequest(updateJobRequest);
        jobService.updateJob(id, updateJobRequest);
    }
}