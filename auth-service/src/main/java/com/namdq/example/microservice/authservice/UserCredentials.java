package com.namdq.example.microservice.authservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentials {
    private String username, password;
}
