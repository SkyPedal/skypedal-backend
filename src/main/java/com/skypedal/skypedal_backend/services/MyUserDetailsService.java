package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.entities.MyUserDetails;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.repo.UserRepo;
import com.skypedal.skypedal_backend.utils.UserRoles;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo repo;

    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User client = repo.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found"));
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority(UserRoles.ROLE_USER));
        return new MyUserDetails(client.getId(), username, client.getPasswordHash(), roles);
    }

}