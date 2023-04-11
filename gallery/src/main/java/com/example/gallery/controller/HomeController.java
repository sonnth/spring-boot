package com.example.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
