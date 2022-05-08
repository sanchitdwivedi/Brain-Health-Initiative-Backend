package com.healthcare.service;

import com.healthcare.dao.UserDao;
import com.healthcare.entity.JwtRequest;
import com.healthcare.entity.JwtResponse;
import com.healthcare.entity.User;
import com.healthcare.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userId = jwtRequest.getUserId();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userId, userPassword);

        UserDetails userDetails = loadUserByUsername(userId);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userDao.findByUserId(Long.parseLong(userId));
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDao.findByUserId(Long.parseLong(userId));
        if(user.getActive()==0) user=null;
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    String.valueOf(user.getUserId()),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with ID: " + userId);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
        return authorities;
    }

    private void authenticate(String userId, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
