package com.example.elasticsearchexample.rest;

import com.example.elasticsearchexample.business.DriverService;
import com.example.elasticsearchexample.entities.DriverEntity;
import com.example.elasticsearchexample.rest.request.DriverCreateRequest;
import com.example.elasticsearchexample.rest.request.DriverUpdateRequest;
import com.example.elasticsearchexample.rest.response.DriverCreateResponse;
import com.example.elasticsearchexample.rest.response.DriverResponse;
import com.example.elasticsearchexample.rest.response.DriverUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    @PostMapping()
    public ResponseEntity<DriverCreateResponse> create(@RequestBody @Valid DriverCreateRequest request) throws IOException {
        DriverEntity createdDriver = driverService.create(request.convertToDriver());

        DriverCreateResponse driverCreateResponse = DriverCreateResponse.from(createdDriver);

        return new ResponseEntity<>(driverCreateResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<DriverUpdateResponse> update(@RequestBody @Valid DriverUpdateRequest request) throws IOException {
        DriverEntity updatedDriver = driverService.update(request.convertToDriver());

        DriverUpdateResponse driverUpdateResponse = DriverUpdateResponse.from(updatedDriver);

        return new ResponseEntity<>(driverUpdateResponse, HttpStatus.OK);
    }

    @DeleteMapping("{driverId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long driverId) {
        driverService.delete(driverId);
    }

    @GetMapping("{driverId}")
    public ResponseEntity<DriverResponse> retrieve(@PathVariable Long driverId) throws IOException {
        return new ResponseEntity<>(DriverResponse.from(driverService.retrieve(driverId)), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DriverResponse>> retrieveAll() throws IOException {
        return new ResponseEntity<>(driverService.retrieveAll()
                .stream()
                .map(DriverResponse::from)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<DriverResponse>> retrieveByUserId(@PathVariable Long userId) throws IOException {
        return new ResponseEntity<>(driverService.retrieveByUserId(userId)
                .stream()
                .map(DriverResponse::from)
                .toList(), HttpStatus.OK);
    }
}
