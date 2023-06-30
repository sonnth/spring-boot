package com.example.image.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Project: image
 * Package: com.example.image.controller
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
    @Autowired
    MessageSource messageSource;

    @RequestMapping("/")
    public String home(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        String message = messageSource.getMessage("hello.message", null, locale);
            return message + env.getProperty("local.server.port");
    }

    @RequestMapping("/images")
    public List<Image> getImages() {
        List<Image> images = Arrays.asList(
                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
        return images;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class Image {
        int id;
        String name;
        String link;
    }
}
