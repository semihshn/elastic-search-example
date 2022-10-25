package com.example.elasticsearchexample.rest.request;

import com.example.elasticsearchexample.entities.DriverEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class DriverCreateRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate birthDate;

    public DriverEntity convertToDriver() {
        return DriverEntity.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .build();
    }
}
