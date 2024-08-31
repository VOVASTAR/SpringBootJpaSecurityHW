package edu.hillel.SpringBootJpaSecurityHW.service;

import edu.hillel.SpringBootJpaSecurityHW.repo.UserRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepositoryJpa.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
    }
}
