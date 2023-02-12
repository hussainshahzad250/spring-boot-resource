package com.sas.resource.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
@Service
public class ResourceService {

    @Autowired
    private ResourceLoader resourceLoader;

    public String getDataUsingResourceUtils() throws IOException {
        File file = ResourceUtils.getFile("classpath:data.txt");
        if (file.exists()) {
            byte[] fileData = Files.readAllBytes(file.toPath());
            String fileContent = new String(fileData);

            log.info("data.txt file content:", fileContent);
            return fileContent;
        }
        return "";
    }

    public String getDataUsingResourceLoader() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:data.txt");
        InputStream inputStream = resource.getInputStream();
        byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
        String fileContent = new String(fileData);
        log.info("data.txt file content:", fileContent);
        return fileContent;

    }

    public String getDataUsingClassPathResource() throws IOException {
        Resource resource = new ClassPathResource("data.txt");
        InputStream inputStream = resource.getInputStream();
        byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
        String fileContent = new String(fileData);
        log.info("data.txt file content:", fileContent);
        return fileContent;

    }
}
