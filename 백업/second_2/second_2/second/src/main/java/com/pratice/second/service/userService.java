package com.pratice.second.service;

import com.pratice.second.dto.userDto;
import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.userRepository;
import com.pratice.second.user.config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
@Data
public class userService {
    @Autowired
    private userRepository userrepository;

    public userEntity createUser(userDto dto) {

        userEntity entity = dto.toJoinEntity();

        if (entity.getUser_id() != null)
            return null;

        return userrepository.save(entity);
    }

    public boolean confirmUser(String id) {
        userEntity entity = userrepository.findByid(id);
        if (entity != null) {
            if (entity.getId().equals(id)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean confirmLogin(String id, String password) {
        userEntity entity = userrepository.findByid(id);
        if (entity != null) {
            if (entity.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void updateUser(userDto dto) {
        userEntity newEntity = dto.toJoinEntity();
        userEntity target = userrepository.findById(newEntity.getUser_id()).orElse(null);
        if (target != null) {
            userrepository.save(newEntity);
            config.userName = newEntity.getId();
        }
    }

    public void deleteUser(String name) {
        userEntity target = userrepository.findByid(name);
        if (target != null) {
            config.isLogin = false;
            config.userName = null;
            config.userPassword = null;
            userrepository.delete(target);
        }
    }
}
