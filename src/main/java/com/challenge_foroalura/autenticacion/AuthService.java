package com.challenge_foroalura.autenticacion;

import com.challenge_foroalura.TokenServices.AuService;
import com.challenge_foroalura.usuarios.IUserRepository;
import com.challenge_foroalura.usuarios.UserRole;
import com.challenge_foroalura.usuarios.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private AuService auService;
    private IUserRepository iUserRepository;
    private  PasswordEncoder passwordEncoder;
    private  AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder().name(request.getName()).username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enable(true)
                .role(UserRole.USER)
                .build();
        iUserRepository.save(usuario);
        return AuthResponse.builder()
                .token(auService.getToken(usuario))
                .build();
    }
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate (new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        UserDetails user = iUserRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = auService.getToken(user);
        return AuthResponse.builder().token(token).build();

    }


}
