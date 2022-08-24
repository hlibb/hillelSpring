package com.example.hillelSpring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {
    private String type;
    private String age;
    private String noise;
}
