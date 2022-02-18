package com.healthcare.service;

import com.healthcare.dao.DoctorDao;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.JwtRequest;
import com.healthcare.entity.JwtResponse;
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
    private DoctorDao doctorDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String doctorId = jwtRequest.getDoctorId();
        String doctorPassword = jwtRequest.getDoctorPassword();
        authenticate(doctorId, doctorPassword);

        UserDetails userDetails = loadUserByUsername(doctorId);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        Doctor doctor = doctorDao.findByHealthId(Long.parseLong(doctorId));
        return new JwtResponse(doctor, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String doctorId) throws UsernameNotFoundException {
        Doctor doctor = doctorDao.findByHealthId(Long.parseLong(doctorId));

        if (doctor != null) {
            return new org.springframework.security.core.userdetails.User(
                    String.valueOf(doctor.getHealthId()),
                    doctor.getPassword(),
                    getAuthority(doctor)
            );
        } else {
            throw new UsernameNotFoundException("Doctor not found with ID: " + doctorId);
        }
    }

    private Set getAuthority(Doctor doctor) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + doctor.getRole().getRoleName()));
        return authorities;
    }

    private void authenticate(String doctorId, String doctorPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(doctorId, doctorPassword));
        } catch (DisabledException e) {
            throw new Exception("DOCTOR_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
