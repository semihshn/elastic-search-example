package com.example.elasticsearchexample.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntity {

    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
