package com.pratice.second.service;

import com.pratice.second.entity.totalEntity;
import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.totalRepository;
import com.pratice.second.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class searchService {
    @Autowired
    totalRepository totalRepository;

    @Autowired
    userRepository userRepository;

    public userEntity userSearch(String name) {
        userEntity entity = userRepository.findByid(name);
        return entity;
    }

    public totalEntity totalSearch(Long id) {
        totalEntity entity = totalRepository.findById(id).orElse(null);
        return entity;
    }
}
