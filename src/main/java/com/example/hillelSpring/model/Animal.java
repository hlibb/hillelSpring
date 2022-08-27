package com.example.hillelSpring.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Builder
public class Animal {
    private Integer animal_id;
    private String type;
    private int age;
    private String noise;
}
