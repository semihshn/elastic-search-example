package com.example.elasticsearchexample.rest.response;

import com.example.elasticsearchexample.entities.DriverEntity;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverUpdateResponse {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public static DriverUpdateResponse from(DriverEntity driver) {
        DriverUpdateResponse driverUpdateResponse = new DriverUpdateResponse();
        driverUpdateResponse.id = driver.getId();
        driverUpdateResponse.userId = driver.getUserId();
        driverUpdateResponse.firstName = driver.getFirstName();
        driverUpdateResponse.lastName = driver.getLastName();
        driverUpdateResponse.birthDate = driver.getBirthDate();
        return driverUpdateResponse;
    }
}
