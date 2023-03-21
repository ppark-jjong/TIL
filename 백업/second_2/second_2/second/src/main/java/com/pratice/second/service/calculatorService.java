package com.pratice.second.service;

import com.pratice.second.entity.exerciseEntity;
import com.pratice.second.entity.totalEntity;
import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.exerciseRepository;
import com.pratice.second.repository.totalRepository;
import com.pratice.second.repository.userRepository;
import com.pratice.second.user.config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
public class calculatorService {

    @Autowired
    userRepository userRepository;
    @Autowired
    exerciseRepository exerciseRepository;
    @Autowired
    totalRepository totalRepository;

    public boolean confirmExercise(String name) {
        exerciseEntity entity = exerciseRepository.findByname(name);
        if (entity != null) {
            return true;
        }else return false;
    }

    public double calculate(String name, int time) {
        log.info(name);
        double result;
        exerciseEntity entity = exerciseRepository.findByname(name);
        log.info(entity.getName());
        if (entity != null) {
            result = Math.round((entity.getCalorie() * time)*100) / 100.0;
            return result;
        } else return 0;
    }

    public double calculateBMI(String name) {
        userEntity entity = userRepository.findByid(config.userName);
        double height = Integer.parseInt(entity.getHeight());
        double weight = Integer.parseInt(entity.getWeight());
        double h = height / 100;
        double bmiq = weight / (h * h);
        double bmi = Math.round(bmiq * 100) / 100.0;
        return bmi;
    }

    public double calculateBmiAverage(double bmi, int age, Long sex) {
        if (sex == 0) {
            if (bmi > 40) { return 0.17; }
            if (bmi > 30 && bmi < 40) { return 7.66; }
            if (bmi > 25 && bmi < 30) { return 40.39; }
            if (bmi > 18.5 && bmi < 25) {return 50.36; }
            if (bmi < 18.5) {return 1.42; }
        } else if (sex == 1) {
            if (bmi > 40) { return 0.14; }
            if (bmi > 30 && bmi < 40) { return 5.02; }
            if (bmi > 25 && bmi < 30) { return 24.07; }
            if (bmi > 18.5 && bmi < 25) {return 65.67; }
            if (bmi < 18.5) {return 4.92; }
        }
        return 0;
    }

    public String calculateBMIS(double bmi) {
        String bmis;
        if(bmi < 20) {
            bmis = "저체중";
        }
        else if(bmi <= 24) {
            bmis = "정상";
        }
        else if(bmi <= 29) {
            bmis = "과체중";
        }
        else {
            bmis = "비만";
        }
        return bmis;
    }

    public double countChicken(double cal) {
        double count = Math.round(cal/1000)*10/10.0;
        return count;
    }

    public int countTaxi(int time) {
        int count = time * 281;
        return count;
    }

    public double countMovie(int time) {
        double count = Math.round(time/110)*10/10.0;
        return count;
    }

    public int pay(int time) {
        int pay = 160 * time;
        return pay;
    }

    public int music(int time) {
        int music = time / 4;
        return music;
    }

    public void saveTotal(int time, double calorie) {
        userEntity ue = userRepository.findByid(config.userName);
        totalEntity te = totalRepository.findById(ue.getUser_id()).orElse(null);
        if (te == null) {
            totalEntity newtotal = new totalEntity(ue.getUser_id(), ue, time, calorie);
            totalRepository.save(newtotal);
            return;
        }
        int updateTime = te.getTime()+time;
        double updateCal = te.getCalorie()+calorie;
        totalEntity updateTotal = new totalEntity(ue.getUser_id(), ue, updateTime, updateCal);
        totalRepository.save(updateTotal);
    }
}