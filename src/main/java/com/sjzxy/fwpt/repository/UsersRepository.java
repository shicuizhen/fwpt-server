package com.sjzxy.fwpt.repository;

import com.sjzxy.fwpt.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @data 2020-11-23 17:20:20
 * @author scz
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
//    @Query("select a from Users a where a.username = ?1")
//    Users findByUsername(String username);
}
