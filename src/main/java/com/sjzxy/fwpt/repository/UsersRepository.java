package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findAllById(Integer id);
}
