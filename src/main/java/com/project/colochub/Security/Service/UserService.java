package com.project.colochub.Security.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.colochub.Exceptions.Exception.AlreadyExisting;
import com.project.colochub.Exceptions.Exception.InvalidCredentials;
import com.project.colochub.Exceptions.Exception.NotFound;
import com.project.colochub.Security.JWT.Services.JwtService;
import com.project.colochub.Security.JWT.Token.Token;
import com.project.colochub.Security.JWT.Token.TokenRepository;
import com.project.colochub.Security.JWT.Token.TokenType;
import com.project.colochub.Security.Model.DTO.AuthenticationRequest;
import com.project.colochub.Security.Model.DTO.AuthenticationResponse;
import com.project.colochub.Security.Model.DTO.RegisterRequest;
import com.project.colochub.Security.Model.Entity.User;
import com.project.colochub.Security.Model.Enums.Status;
import com.project.colochub.Security.Model.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        if (userRepository.findByEmailAndPhone(request.getEmail(), request.getPhone()).isPresent()){
            throw new AlreadyExisting("User Already Existing");
        }else{
            var user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .phone(request.getPhone())
                    .role(request.getRole())
                    .status(Status.PENDING)
                    .build();

            var savedManager = userRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);
            saveUserToken(savedManager, jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }
    }

    public List<User> getInactiveUsers(){
        return userRepository.findByStatus(Status.PENDING);
    }
    public String registration(RegisterRequest request){
        if (userRepository.findByEmailAndPhone(request.getEmail(), request.getPhone()).isPresent()){
            throw new AlreadyExisting("User Already Existing");
        }else{
            User user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .role(request.getRole())
                    .status(Status.PENDING)
                    .build();

            userRepository.save(user);
            return "Your account is created and waiting for Admin validation, thank you! ";
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        if (user.getStatus().equals(Status.ACCEPTED)){
            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);
            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }else {
            throw new NotFound("Account not accepted yet!");
        }
    }

    public User Account_confirmation(String userEmail, String status){
        if (userEmail != null){
            User user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            System.out.println(status);
            if (status.equals("ACCEPTED")){
                user.setStatus(Status.ACCEPTED);
                userRepository.save(user);
            } else if (status.equals("REFUSED")) {
                user.setStatus(Status.REFUSED);
                userRepository.save(user);
            }else {
                throw new InvalidCredentials("Invalid Status : " + status);
            }
            return user;
        }else {
            throw new InvalidCredentials("Email not found!");
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
