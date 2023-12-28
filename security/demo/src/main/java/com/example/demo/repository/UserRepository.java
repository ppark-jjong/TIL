package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository가 따로 없어도 IoC가 된다 (JpaRepository를 상속했기 때문임)
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //JPA Query Methods
    public User findByUsername(String username);
}