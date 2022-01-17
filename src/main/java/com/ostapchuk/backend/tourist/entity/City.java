package com.ostapchuk.backend.tourist.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "city")
@Builder
@Data
public class City {

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "message")
    private String message;
}
