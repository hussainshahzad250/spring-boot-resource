package com.sas.resource.controller;

import com.sas.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getDataUsingResourceUtils")
    public String getDataUsingResourceUtils() throws IOException {
        return resourceService.getDataUsingResourceUtils();
    }

    @GetMapping("/getDataUsingResourceLoader")
    public String getDataUsingResourceLoader() throws IOException {
        return resourceService.getDataUsingResourceLoader();
    }

    @GetMapping("/getDataUsingClassPathResource")
    public String getDataUsingClassPathResource() throws IOException {
        return resourceService.getDataUsingClassPathResource();
    }
}
