package com.example.hillelSpring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String surname;
    private int age;
    private boolean gender;
}
