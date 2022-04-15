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



@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @ApiOperation(value = "ID ile iş bulma.",notes = "Girilen idli işi getirir.")
    @GetMapping("/{id}")
    public JobResponseDto findJobById(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @GetMapping("/jobs")
    public List<JobResponseDto> findAll() {
        return jobService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createJob(@Valid @RequestBody CreateJobRequest jobRequest) {
        validateJobCreateRequest(jobRequest);
        jobService.createJob(jobRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateJob(@PathVariable Long id, @RequestBody UpdateJobRequest updateJobRequest) {
        jobService.updateJob(id, updateJobRequest);
    }
}