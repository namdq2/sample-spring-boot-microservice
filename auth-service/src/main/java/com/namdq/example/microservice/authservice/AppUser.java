package com.namdq.example.microservice.authservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppUser {
    private Integer id;
    private String username, password, role;
}
