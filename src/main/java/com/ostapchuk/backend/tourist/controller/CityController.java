package com.ostapchuk.backend.tourist.controller;

import com.ostapchuk.backend.tourist.dto.CityDto;
import com.ostapchuk.backend.tourist.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/{name}")
    public String findByName(@PathVariable final String name) {
        return cityService.findByName(name);
    }

    @PostMapping
    public void save(@RequestBody @Validated final CityDto cityDto) {
        cityService.save(cityDto);
    }

    @PatchMapping
    public void update(@RequestBody @Validated final CityDto cityDto) {
        cityService.update(cityDto);
    }

    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable final String name) {
        cityService.deleteByName(name);
    }
}
