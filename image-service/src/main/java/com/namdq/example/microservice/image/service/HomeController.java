package com.namdq.example.microservice.image.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/images")
    public List<Image> getImages() throws Exception {
        log.info("Creating a image list... ");

        List<Image> images = Arrays.asList(
                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112")
        );

//        create demo error
//        try {
//            throw new Exception("Images can't be fetched");
//        } catch (Exception e) {
//            throw e;
//        }
        log.info("Returning images...");
        return images;
    }
}
