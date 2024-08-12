package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.entities.MyUserDetails;
import com.skypedal.skypedal_backend.entities.MyUser;
import com.skypedal.skypedal_backend.repo.UserRepo;
import com.skypedal.skypedal_backend.utils.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final MyUser client = repo.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found"));
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority(UserRoles.ROLE_USER));
        return new MyUserDetails(client.getId(), username, client.getHash(), roles);
    }

}