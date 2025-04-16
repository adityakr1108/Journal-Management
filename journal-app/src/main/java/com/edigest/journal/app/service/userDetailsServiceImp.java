package com.edigest.journal.app.service;

import com.edigest.journal.app.entity.userEntry;
import com.edigest.journal.app.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class userDetailsServiceImp implements UserDetailsService {

    @Autowired
    private userRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userEntry user = userRepository.findByUserName(username);
        if(user != null){
          UserDetails userDetails =  org.springframework.security.core.userdetails.User.builder().
                    username(user.getUserName()).
                    password(user.getPassword()).
                    roles(user.getRoles().toArray(new String[0])).
                     build();
            return userDetails;
        }
        throw new UsernameNotFoundException(username);
    }
}
