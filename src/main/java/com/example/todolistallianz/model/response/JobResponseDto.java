package com.example.todolistallianz.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JobResponseDto {

    @ApiModelProperty(notes = "Job ID", name = "id", required = true)
    private Long id;

    @ApiModelProperty(notes = "Job name", name = "name", required = true)
    private String name;

    @ApiModelProperty(notes = "Job description", name = "description", required = true)
    private String description;

    @ApiModelProperty(notes = "Job status", name = "status", required = false)
    private String status;

}
