package com.example.bpm.service;

import com.example.bpm.dto.LoginForm;
import com.example.bpm.dto.UserDto;
import com.example.bpm.entity.UserEntity;
import com.example.bpm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    //유저 정보 저장 (회원가입)
    public void save(UserDto userDto) {
        log.info("서비스 정상 접근 (서비스)");
        UserEntity userEntity = UserEntity.toUserEntity(userDto);
        log.info("레파지토리 접근 전(서비스)");
        userRepository.save(userEntity);
        log.info("레파지토리 정상 저장(서비스)");
    }

    //유저 로그인
    public UserDto login(LoginForm loginForm) {
        //여기서 클라이언트에게서 받은 정보랑 DB의 값과 비교해야하는데 클라이언트에서 받은 키는 email 밖에 없어서 DB에 중복키 확인이 불가능함
     Optional<UserEntity> loginUserInfo = userRepository.findById(loginForm.getEmail());
        if (loginUserInfo.isPresent()) {
            log.info("일치하는 이메일 찾음(서비스 작동)");
            UserEntity userEntity = loginUserInfo.get();
            if (userEntity.getPassword().equals(loginForm.getPassword())) {
                log.info("로그인성공 (서비스 작동)");
                UserDto result = UserDto.toUserDto(userEntity);
                return result;
            } else {
                log.info("비밀번호 불일치(서비스 작동)");
                return null;
            }
        } else {
            log.info("일치하는 이메일의 정보가 없음 (서비스 작동)");
            return null;
        }
    }

    //사용자 목록 가져오기
    public List<UserDto> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userDtoList.add(UserDto.toUserDto(userEntity));
        }
        return userDtoList;
    }
//
//    //로그인 시 사용자 email로 로그인
//    public UserDto findByEmail(UserDto userDto) {
//        UserPKEntity userPKEntity = new UserPKEntity(userDto.getUuid(), userDto.getEmail());
//        Optional<UserEntity> loginUserInfo = userRepository.findById(userDto.getUuid());
//        if (loginUserInfo.isPresent()) {
//            return UserDto.toUserDto(loginUserInfo.get());
//        } else {
//            return null;
//        }
//    }

//
//    //업데이트를 위한 현재 정보 가져오기
//    public UserDto updateForm(UserDto userDto) {
//        UserPKEntity userPKEntity = new UserPKEntity(userDto.getUuid(), userDto.getEmail());
//        Optional<UserEntity> loginUserInfo = userRepository.findById(userDto.getUuid());
//        if (loginUserInfo.isPresent()) {
//            return UserDto.toUserDto(loginUserInfo.get());
//        } else {
//            return null;
//        }
//    }
//
//
//
//    //유저 탈퇴
//    public void deleteById(UserDto userDto) {
//        UserPKEntity userPKEntity = new UserPKEntity(userDto.getUuid(), userDto.getEmail());
//        userRepository.deleteById(userDto.getUuid());
//    }
//
//
}