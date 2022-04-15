package com.example.todolistallianz.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JobResponseDto {

    private Long id;
    private String name;
    private String description;
    private String status;

}
