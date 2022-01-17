package com.ostapchuk.backend.tourist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CityDto {

    @NotBlank(message = "Name can not be empty or null")
    private String name;

    @NotBlank(message = "Message can not be empty or null")
    private String message;
}
