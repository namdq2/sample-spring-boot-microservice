package com.namdq.example.microservice.gallery.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    private Integer id;
    private List<Object> images;

    public Gallery(Integer id) {
        this.id = id;
    }
}
