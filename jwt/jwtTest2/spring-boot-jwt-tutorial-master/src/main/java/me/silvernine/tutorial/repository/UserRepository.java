package me.silvernine.tutorial.repository;

import me.silvernine.tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//  @EntityGraph == 쿼리가 수행될 때 Eager 조회로 authorities 정보를 같이 가져오게 됨
//   autorities 정보를 같이 가져오기 위함
   @EntityGraph(attributePaths = "authorities")
   Optional<User> findOneWithAuthoritiesByUsername(String username);
}
