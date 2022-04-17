package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);

    @Query(value = "SELECT * FROM user u WHERE u.name LIKE %:name%", nativeQuery = true)
    public Page<User> findUserByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT *" +
            "FROM user u" +
            "WHERE u.name = :name",nativeQuery = true)
    List<User> findUserByName(@Param("name") String name);
}
