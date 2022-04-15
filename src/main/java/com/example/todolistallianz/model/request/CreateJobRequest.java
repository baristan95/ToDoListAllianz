package com.example.todolistallianz.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobRequest {

    @NotNull(message = "isim bos birakilamaz")
    private String name;
    @NotNull(message = "tanim bos birakilamaz")
    private String description;
    private String status;
}
