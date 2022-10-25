package com.example.elasticsearchexample.rest.response;

import com.example.elasticsearchexample.entities.DriverEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponse {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birhDate;

    public static DriverResponse from(DriverEntity driver) {
        return DriverResponse.builder()
                .id(driver.getId())
                .userId(driver.getUserId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .birhDate(driver.getBirthDate())
                .build();
    }
}
