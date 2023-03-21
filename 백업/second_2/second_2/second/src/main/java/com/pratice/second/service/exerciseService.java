package com.pratice.second.service;

import com.pratice.second.dto.exerciseDto;
import com.pratice.second.entity.exerciseEntity;
import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.exerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class exerciseService {
    @Autowired
    exerciseRepository exerciseRepository;

    public void addExercise(exerciseDto dto) {
        exerciseEntity entity = dto.toExerciseEntity();
        exerciseRepository.save(entity);
        return;
    }

    public boolean exerciseConfirm(exerciseDto dto) {
        exerciseEntity entity = exerciseRepository.findByname(dto.getName());
        if (entity != null) {
            return true;
        } return false;
    }
}
