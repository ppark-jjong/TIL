package com.example.Photoble.service;

import com.example.Photoble.entity.*;
import com.example.Photoble.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImagetagRepository imageTagRepository;

    @Autowired
    private BoardimageRepository boardimageRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    public Boolean loginProcess(User user){
        User findUser = userRepository.findByUseridAndPassword(user.getUserid(), user.getPassword());

        if(findUser == null){
            return true;
        }

        return false;
    }

    public Boolean joinProcess(User user){
        User selectUser = userRepository.findByUserid(user.getUserid());

        if (selectUser == null){

            userRepository.save(user);

            return false;
        }
        else if(selectUser.getUserid() != null){
            return true;
        }
    }

    public User selectUser(String user){
        return userRepository.findByUserid(user);
    }

    public void changePassword(String user, String password){
        User userEntity = userRepository.findByUserid(user);

        userEntity.setPassword(password);

        userRepository.save(userEntity);
    }

    public void changeEmail(String user, String email){
        User userEntity = userRepository.findByUserid(user);

        userEntity.setEmail(email);

        userRepository.save(userEntity);
    }

    public void UserExit(String user){
        List<Board> boardList = boardRepository.findByUser(user);
        List<Image> imageList = imageRepository.findByUser(user);
        List<Comments> userCommentsList = commentsRepository.findByUser(user);

        for (Comments comments: userCommentsList) {
            commentsRepository.delete(comments);
        }

        for (Board board: boardList) {
            List<BoardImage> boardImageList = boardimageRepository.findByBoard(board.getId());

            for (BoardImage boardImage: boardImageList) {
                boardimageRepository.delete(boardImage);
            }

            List<Comments> commentsList = commentsRepository.findByBoard(board.getId());

            for (Comments comments : commentsList){
                commentsRepository.delete(comments);
            }

            boardRepository.delete(board);
        }

        for (Image image : imageList){
            List<ImageTag> imageTagList = imageTagRepository.findByImage(image.getImagename());

            for (ImageTag imageTag: imageTagList) {
                imageTagRepository.delete(imageTag);
            }

            imageRepository.delete(image);
        }

        userRepository.delete(userRepository.findByUserid(user));
    }

    public Page<Board> boardList(String user, Pageable pageable) {
        return  boardRepository.findByUser(user, pageable);
    }

    public Page<Board> boardSearchTitle(String searchKeyword, Pageable pageable){
        return  boardRepository.findByTitleContaining(searchKeyword, pageable);
    }


}
