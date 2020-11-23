package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.doamin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @data 2020-11-23 17:20:20
 * @author scz
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    @Query("select a from User a where a.username = ?1")
    User findByUsername(String username);
}
