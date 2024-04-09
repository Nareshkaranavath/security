package com.springSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecurity.model.User;
import com.springSecurity.repository.UserRepository;
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
        User user = userRepository.findUserByUsername(username) 
                .orElseThrow(() -> new UsernameNotFoundException("User not present")); 
        return user; // Assuming User implements UserDetails
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
