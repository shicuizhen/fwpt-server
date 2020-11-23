package com.sjzxy.fwpt.security.dao;

import com.sjzxy.fwpt.doamin.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 登录用户信息类
 * @data 2020-11-23 10:46:20
 * @author scz
 */
public class LoginUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 用户信息,作为一个变量存放在UserDetails类型的LoginUser中
     */
    private User user;

    public LoginUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
