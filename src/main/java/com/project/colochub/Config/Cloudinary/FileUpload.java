package com.project.colochub.Config.Cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
public interface FileUpload {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
