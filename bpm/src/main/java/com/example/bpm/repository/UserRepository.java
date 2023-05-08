package com.example.bpm.repository;

import com.example.bpm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository의 매개변수는 JPA로 활용할 Entity 클래스 명과, 그 Entity의 PK 데이터 타입을 인자로 적는다
public interface UserRepository extends JpaRepository<UserEntity, String> {


}


