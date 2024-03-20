package com.project.colochub.Security.Controller;


import com.project.colochub.Security.Model.DTO.AuthenticationRequest;
import com.project.colochub.Security.Model.DTO.AuthenticationResponse;
import com.project.colochub.Security.Model.DTO.RegisterRequest;
import com.project.colochub.Security.Model.Entity.User;
import com.project.colochub.Security.Service.LogoutService;
import com.project.colochub.Security.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final UserService service;
    private final LogoutService logout;

    @PostMapping("/register")
    public ResponseEntity<String> registration(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.registration(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        System.out.println("========================");
        System.out.println("the request :" + request);
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        logout.logout(request, response, authentication);
    }

    @GetMapping("users")
    private List<User> getInactiveAccounts(){
        System.out.println("inside the controller");
        return service.getInactiveUsers();
    }

}
