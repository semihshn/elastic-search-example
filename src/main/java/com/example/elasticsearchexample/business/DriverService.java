package com.example.elasticsearchexample.business;

import com.example.elasticsearchexample.elastic.ElasticSearchPort;
import com.example.elasticsearchexample.entities.DriverEntity;
import com.example.elasticsearchexample.util.exception.ExceptionType;
import com.example.elasticsearchexample.util.exception.SemDataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverService {

    private final ElasticSearchPort elasticSearchPort;

    private static final String DRIVER_INDEX_NAME = "drivers";
    private Long counter=1L;

    public DriverEntity create(DriverEntity driver) throws IOException {
        driver.setId(counter);
        counter++;
        elasticSearchPort.createIndex(DRIVER_INDEX_NAME, driver.getId(), driver);

        return driver;
    }

    public List<DriverEntity> retrieveAll() throws IOException {

        log.info("Elasticsearch started");

        List<DriverEntity> driverList;

        try {
            driverList = elasticSearchPort.search(DRIVER_INDEX_NAME, DriverEntity.class);
        } catch (RuntimeException e) {
            throw new SemDataNotFoundException(ExceptionType.DRIVER_DATA_NOT_FOUND, e.getMessage());
        }

        checkIfEmpty(driverList);

        return driverList;
    }

    public DriverEntity retrieve(Long id) {

        DriverEntity driver;

        try {
            driver = elasticSearchPort.retrieveById(DRIVER_INDEX_NAME, id, DriverEntity.class);
        } catch (RuntimeException | IOException e) {
            throw new SemDataNotFoundException(ExceptionType.DRIVER_DATA_NOT_FOUND, e.getMessage());
        }

        checkIfNull(driver);

        return driver;
    }

    public List<DriverEntity> retrieveByUserId(Long id) throws IOException {

        List<DriverEntity> driverList;

        try {
            driverList = elasticSearchPort.retrieveByField(DRIVER_INDEX_NAME, "userId", id.toString(), DriverEntity.class);
        } catch (RuntimeException e) {
            throw new SemDataNotFoundException(ExceptionType.DRIVER_DATA_NOT_FOUND, e.getMessage());
        }

        checkIfEmpty(driverList);

        return driverList;
    }

    public DriverEntity update(DriverEntity driver) throws IOException {
        retrieve(driver.getId());
        elasticSearchPort.update(DRIVER_INDEX_NAME, driver.getId(), driver);

        return driver;
    }

    public void delete(Long driverId) {
        retrieve(driverId);
        elasticSearchPort.delete(DRIVER_INDEX_NAME, driverId.toString());
    }

    private void checkIfEmpty(List<DriverEntity> driverList) {
        if (driverList.isEmpty()) {
            throw new SemDataNotFoundException(ExceptionType.DRIVER_DATA_NOT_FOUND, "Herhangi bir kayıt bulunamadı.");
        }
    }

    private void checkIfNull(DriverEntity driver) {
        if (driver == null) {
            throw new SemDataNotFoundException(ExceptionType.DRIVER_DATA_NOT_FOUND, "Herhangi bir kayıt bulunamadı.");
        }
    }
}
