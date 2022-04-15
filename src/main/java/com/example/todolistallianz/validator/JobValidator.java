package com.example.todolistallianz.validator;

import com.example.todolistallianz.model.request.CreateJobRequest;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.procedure.ParameterMisuseException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JobValidator {

    public static void validateJobCreateRequest(CreateJobRequest request) {
        if (Objects.isNull(request.getName()) || Strings.isBlank((request.getName()))) {
            throw new ParameterMisuseException("Isim bos");
        }
        if (Objects.isNull(request.getDescription()) || Strings.isBlank((request.getDescription()))) {
            throw new ParameterMisuseException("Tanim bos");
        }
        if (Objects.isNull(request.getStatus()) || Strings.isBlank((request.getStatus()))) {
            throw new ParameterMisuseException("Durum bos");
        }
    }
}
