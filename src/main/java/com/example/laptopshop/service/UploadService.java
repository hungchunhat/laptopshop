package com.example.laptopshop.service;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadService {
    private final ServletContext servletContext;

    UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveUpload(MultipartFile file, String target) {
        if (file.isEmpty()) return null;
        String fileName = "";
        String rootPath = servletContext.getRealPath("/resources/images/" + target);
        try {
            byte[] bytes = file.getBytes();
            File dir = new File(rootPath);
            if (!dir.exists()) dir.mkdirs();
            fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
