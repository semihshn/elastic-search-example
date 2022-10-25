package com.example.elasticsearchexample.rest.response;

import com.example.elasticsearchexample.entities.DriverEntity;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverCreateResponse {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public static DriverCreateResponse from(DriverEntity driver) {
        DriverCreateResponse driverCreateResponse = new DriverCreateResponse();
        driverCreateResponse.id = driver.getId();
        driverCreateResponse.userId = driver.getUserId();
        driverCreateResponse.firstName = driver.getFirstName();
        driverCreateResponse.lastName = driver.getLastName();
        driverCreateResponse.birthDate = driver.getBirthDate();
        return driverCreateResponse;
    }
}
