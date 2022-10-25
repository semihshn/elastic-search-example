package com.example.elasticsearchexample.rest.request;

import com.example.elasticsearchexample.entities.DriverEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class DriverUpdateRequest {

    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate birhDate;

    public DriverEntity convertToDriver() {
        return DriverEntity.builder()
                .id(id)
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birhDate)
                .build();
    }
}
