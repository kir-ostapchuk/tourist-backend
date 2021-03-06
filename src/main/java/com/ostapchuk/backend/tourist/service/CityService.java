package com.ostapchuk.backend.tourist.service;

import com.ostapchuk.backend.tourist.dto.CityDto;
import com.ostapchuk.backend.tourist.entity.City;
import com.ostapchuk.backend.tourist.exception.EntityNotFoundException;
import com.ostapchuk.backend.tourist.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ostapchuk.backend.tourist.util.Const.EXCEPTION_MSG;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public String findByName(final String name) {
        return cityRepository.findByNameIgnoreCase(name)
                             .map(City::getMessage)
                             .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_MSG));
    }

    public void save(final CityDto cityDto) {
        final City city = City.builder()
                              .name(cityDto.getName())
                              .message(cityDto.getMessage())
                              .build();
        cityRepository.save(city);
    }

    public void update(final CityDto cityDto) {
        final City city = cityRepository.findByNameIgnoreCase(cityDto.getName())
                                        .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_MSG));
        city.setMessage(cityDto.getMessage());
        cityRepository.save(city);
    }

    public void deleteByName(final String name) {
        cityRepository.deleteByName(name);
    }
}
