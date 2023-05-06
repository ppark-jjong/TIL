package com.example.Photoble.controller;

import com.example.Photoble.entity.Image;
import com.example.Photoble.service.CloudService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class CloudController {

    @Autowired
    CloudService cloudService;

    @GetMapping("/")
    public String home(){

        return "redirect:/cloud/main";
    }

    @GetMapping("/cloud/main")
    public String cloudMain(Model model, HttpSession session, String searchKeyword){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        List<Image> userImage = null;

        try {
            if(searchKeyword.isBlank()) {
                searchKeyword = null;
            }
        }
        catch (Exception e){

        }

        if (searchKeyword == null){
            userImage =  cloudService.returnUserImage(session);
        }
        else {
            userImage = cloudService.returnUserImageKeyword(session, searchKeyword);
        }

        model.addAttribute("userImage", userImage);
        model.addAttribute("searchKeyword", searchKeyword);

        return "cloud/cloud_main";
    }

    @GetMapping("/cloud/upload")
    public String getCloudUpload(HttpSession session){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        return "cloud/cloud_upload";
    }

    @PostMapping("/cloud/uploding")
    public String uploading(HttpSession session, String tag, Model model, MultipartFile multipartFile) throws Exception{
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        cloudService.upload(session, tag, multipartFile);

        model.addAttribute("title", "Success!");
        model.addAttribute("message","이미지 업로드 성공");
        model.addAttribute("url", "/cloud/main");

        return "sub/alert";
    }

    @GetMapping("/cloud/view")
    public String getCloudView(HttpSession session, Model model, String imagename){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        Image image = cloudService.returnImage(imagename);
        String tag = cloudService.returnImageTag(imagename);

        model.addAttribute("image", image);
        model.addAttribute("tag", tag);
        return "/cloud/cloud_view";
    }

    @PostMapping("/cloud/modify")
    public String postCloudModify(String pastTag, String tag, String name){

        cloudService.modifyCloudTag(pastTag, tag, name);
        return "redirect:/cloud/main";
    }

    @GetMapping("/cloud/delete")
    public  String getCloudDelete(String name, Model model){

        cloudService.deleteCloud(name);

        model.addAttribute("title", "Success!");
        model.addAttribute("message","이미지 삭제 성공");
        model.addAttribute("url", "/cloud/main");

        return "sub/alert";
    }

    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping("/cloud/download")
    public ResponseEntity<Resource> downloadFile(String name) {
        Resource resource = resourceLoader.getResource("classpath:static/cloudImage/"+ name);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                        .filename(name, StandardCharsets.UTF_8)
                        .build()
                        .toString())
                .body(resource);
    }
}
