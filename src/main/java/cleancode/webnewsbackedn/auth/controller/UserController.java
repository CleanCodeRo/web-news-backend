package cleancode.webnewsbackedn.auth.controller;


import cleancode.webnewsbackedn.auth.model.AuthenticationRequest;
import cleancode.webnewsbackedn.auth.model.AuthenticationResponse;
import cleancode.webnewsbackedn.auth.model.RegisterRequest;
import cleancode.webnewsbackedn.auth.model.User;
import cleancode.webnewsbackedn.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }


    @PostMapping("/auth/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(userService.authenticate(authenticationRequest));
    }

    @GetMapping("/getUserWithToken")
    public ResponseEntity<User> getUserWithToken(@RequestHeader("Authorization") String authHeader){
        return ResponseEntity.ok(userService.getUserWithToken(authHeader));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
