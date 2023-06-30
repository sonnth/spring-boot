package com.example.gallery.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Project: spring-boot
 * Package: com.example.gallery.controller
 * This is an example...
 *
 * @author sonnth
 * @since 4/7/23
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/test")
    public String getGallery() {
        // create gallery object
//        Gallery gallery = new Gallery();
//        gallery.setId(id);

        // get list of available images
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://image-service/", String.class);
//        List<Object> images = restTemplate.getForObject("http://image-service/images", List.class);
//        gallery.setImages(images);

        return response;
    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

    @Getter@Setter@AllArgsConstructor@NoArgsConstructor
    private class Gallery {
        private Integer id;
        private List<Object> images;
    }
}
