package com.example.demo.Files;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    public final UserService userService;
    public final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        try{
            if(userService.FindByEmail(user.getEmail()).isEmpty()){
                userService.save(user);
                response.put("message", "Zarejestrowano");
                return ResponseEntity.ok(response);
            }else{
                response.put("message", "Coś poszło nie tak");
                return ResponseEntity.ok(response);
            }

        }catch(Exception e){
            response.put("message", "Błąd rejestracji: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        Optional<User> userOpt  = userService.FindByEmail(user.getEmail());
        if(userOpt.isEmpty()){
            response.put("message", "Niepoprawne dane");
            return ResponseEntity.status(401).body(response);
        }

       try{
           Authentication authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
           );
       }catch(Exception e){
            response.put("message", "Niepoprawne dane");
            return ResponseEntity.status(401).body(response);
        }

        session.setAttribute("userId", userOpt.get().getId());
        response.put("message", "Zalogowany " + userOpt.get().getEmail());
        return ResponseEntity.ok(response);

    }

}
