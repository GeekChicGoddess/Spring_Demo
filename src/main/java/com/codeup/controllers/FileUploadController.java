package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by melodytempleton on 6/27/17.
 */
public class FileUploadController {

    @Value("${file-upload-path}")
    private String uploadPath;

    @GetMapping("/fileupload")
    public String showUploadFileForm() {
        return "fileupload";
    }
//
//    @PostMapping("/fileupload")
//    public String saveFile(
//            @RequestParam(name = "file") MultipartFile uploadedFile,
//            Model model,
//            @Valid Post post
//    ) {
//        User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String id =  String.valueOf(user1.getId());
////        String filename =  id + uploadedFile.getOriginalFilename().replace(" ", "_");
//        String filename =  id + String.valueOf(post.getId());
//        String filepath = Paths.get(uploadPath, filename).toString();
//        File destinationFile = new File(filepath);
//        try {
//            uploadedFile.transferTo(destinationFile);
//            model.addAttribute("message", "File successfully uploaded!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            model.addAttribute("message", "Oops! Something went wrong! " + e);
//        }
//        return "fileupload";
//    }
}
