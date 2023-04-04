package com.fptaptech.lab3.controller;

import com.fptaptech.lab3.model.FileStore;
import com.fptaptech.lab3.repository.impl.FileStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/fileStore")
public class FileStoreController {
    @Autowired
    private FileStoreRepository fileStoreRepository;

    @GetMapping("/upload")
    public String viewUpload(){
        return "file/upload";
    }

    @PostMapping("/save-upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        FileStore fileStore = new FileStore();
        fileStore.setName(multipartFile.getOriginalFilename());
        fileStore.setType(multipartFile.getContentType());
        fileStore.setData(multipartFile.getBytes());
        fileStoreRepository.save(fileStore);
        return "redirect:/student/student-list";
    }
    @GetMapping("/view-file/{id}")
    public void displayFile(@PathVariable long id , HttpServletResponse response) throws IOException {
        FileStore fileStore = fileStoreRepository.getById(id);
        response.setContentType(fileStore.getType());
        response.getOutputStream().write(fileStore.getData());
        response.getOutputStream().close();
    }
    @GetMapping("/download-file/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable long id)
    {
        FileStore fileStore = fileStoreRepository.getById(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileStore.getName() + "\"").body(fileStore.getData());
    }
}
