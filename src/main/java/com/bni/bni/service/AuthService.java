package com.bni.bni.service;

import com.bni.bni.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final String[][] users = {
        {"admin", "password123"},
        {"user", "admin123"}
    };

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    // public String register(String username, String password) {
    //     if (repo.existsById(username)) {
    //         logger.warn("PERCOBAAN REGSTRASI DENGAN MENGGUNAKAN USER TERDAFTAR: {}", username);
    //         return "User already exists";
    //     }
    //     User user = new User();
    //     user.setUsername(username);
    //     user.setPasswordHash(encoder.encode(password));
    //     user.setRole("USER");
    //     repo.save(user);

    //     logger.warn("PERCOBAAN REGISTER BERHASIL: {}", username);
    //     return "Registered successfully";
    // }

    // public String login(String username, String password) {
    //     Optional<User> user = repo.findByUsername(username);
    //     if (user.isPresent() && encoder.matches(password, user.get().getPasswordHash())) {
    //         logger.warn("PERCOBAAN LOGIN BERHASIL: {}", username);
    //         return jwtUtil.generateToken(username, user.get().getRole());
    //     }

    //     logger.warn("PERCOBAAN LOGIN GAGAL, USERNAME ATAU PASSWORD SALAH: {}", username);
    //     return null;
    // }

    public String login(String username, String password) {
        for (String[] u : users) {
            if (u[0].equals(username) && u[1].equals(password)) {
                return jwtUtil.generateToken(username, "USER");
            }
        }

        return null;
    }
}
