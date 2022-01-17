package com.ostapchuk.backend.tourist.repository;

import com.ostapchuk.backend.tourist.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends MongoRepository<City, Long> {

    Optional<City> findByName(String name);

    void deleteByName(String name);
}
