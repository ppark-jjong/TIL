package com.example.Photoble.service;

import com.example.Photoble.SubClass.DateNow;
import com.example.Photoble.entity.*;
import com.example.Photoble.repository.BoardimageRepository;
import com.example.Photoble.repository.ImageRepository;
import com.example.Photoble.repository.ImagetagRepository;
import com.example.Photoble.repository.TagRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CloudService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ImagetagRepository imageTagRepository;

    @Autowired
    private BoardimageRepository boardimageRepository;

    public void upload(HttpSession session, String tag, MultipartFile multipartFile) throws IOException {
        Image image = new Image();

        if (multipartFile != null){
            // 파일 저장 경로
            String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\cloudImage";

            // 랜덤 UUID를 생성 하여 UUID_본래 파일 이름 으로 파일 이름 생성
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + multipartFile.getOriginalFilename();

            // 파일이 비어있지 않을때, 파일에 파일 명, 파일 경로 저장
            if(multipartFile.getOriginalFilename() != ""){
                File saveFile = new File(projectPath, fileName);

                // 전달할 파일 저장
                multipartFile.transferTo(saveFile);

                // 데이터 베이스에 전달하기 위해 파일명과 파일 경로를 엔티티에 저장
                image.setImagename(fileName);
                image.setImagepath("/cloudImage/" + fileName);
            }
            image.setUser(session.getAttribute("userName").toString());
            image.setDate(DateNow.timeNow());

            imageRepository.save(image);

            if (tag != null || !tag.equals("")){
                String[] tagarray = tag.trim().split("#");

                for (String savetag: tagarray) {

                    if (savetag.equals(""))
                        continue;

                    Tag intag = new Tag();
                    ImageTag inImageTag = new ImageTag();


                    intag.setTag(savetag.trim());

                    inImageTag.setImage(fileName);
                    inImageTag.setTag(savetag.trim());

                    tagRepository.save(intag);

                    imageTagRepository.save(inImageTag);
                }
            }
        }




    }

    public List<Image> returnUserImage(HttpSession session){
        return imageRepository.findByUser(session.getAttribute("userName").toString());
    }

    public List<Image> returnUserImageKeyword(HttpSession session, String searchKeyword){

        List<Image> imageList = new ArrayList<>();
        List<ImageTag> imageTagList = null;

        if(searchKeyword.trim().charAt(0) == '#'){
            imageTagList = imageTagRepository.findByTag(searchKeyword.replace('#', ' ').trim());
        }
        else {
            imageTagList = imageTagRepository.findByTagContaining(searchKeyword.trim());
        }

        List<String> stringList = new ArrayList<>();

        for (ImageTag imageTag: imageTagList) {
            if (stringList.contains(imageTag.getImage())){
                continue;
            }
            Image image = imageRepository.findByUserAndImagename(session.getAttribute("userName").toString(), imageTag.getImage());

            if (image != null){
                imageList.add(image);
            }
            stringList.add(imageTag.getImage());
        }

        return imageList;
    }

    public Image returnImage(String imagename){
        return imageRepository.findByImagename(imagename);
    }

    public String returnImageTag(String imagename){

        List<ImageTag> imageTagList = imageTagRepository.findByImage(imagename);
        String tag = "";
        for (ImageTag imageTag: imageTagList) {
            tag += " #"+imageTag.getTag();
        }

        return tag.trim();
    }

    public void modifyCloudTag(String pastTag, String tag, String name){
        if (pastTag != null || !pastTag.equals("")){
            String[] tagarray = pastTag.trim().split("#");

            for (String deleteTag: tagarray) {
                ImageTag del = new ImageTag();
                del.setTag(deleteTag.trim());
                del.setImage(name);

                imageTagRepository.delete(del);
            }
        }

        if (tag != null || !tag.equals("")){
            String[] tagarray = tag.trim().split("#");

            for (String savetag: tagarray) {

                if (savetag.equals(""))
                    continue;

                Tag intag = new Tag();
                ImageTag inImageTag = new ImageTag();

                intag.setTag(savetag.trim());

                inImageTag.setImage(name);
                inImageTag.setTag(savetag.trim());

                tagRepository.save(intag);

                imageTagRepository.save(inImageTag);
            }
        }
    }
    public void deleteCloud(String name){
        List<ImageTag> imageTagList = imageTagRepository.findByImage(name);
        List<BoardImage> boardImageList = boardimageRepository.findByImage(imageRepository.findByImagename(name).getImagepath());


        File file = new File(imageRepository.findByImagename(name).getImagepath());

        file.delete();

        for (ImageTag imageTag:imageTagList) {
            imageTagRepository.delete(imageTag);
        }

        for (BoardImage boardImage : boardImageList) {
            boardimageRepository.delete(boardImage);
        }

        imageRepository.delete(imageRepository.findByImagename(name));
    }
}
