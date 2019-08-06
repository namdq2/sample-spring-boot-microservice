package com.namdq.example.microservice.image.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {

    private Integer id;

    private String title;

    private String url;
}
