package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.dto.request.LoginRequestDto;
import org.enes.dto.request.RegisterRequestDto;
import org.enes.dto.response.LoginResponseDto;
import org.enes.dto.response.RegisterResponseDto;
import org.enes.entity.User;
import org.enes.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    public final UserService userService;


    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<User>> findById(Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }


    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user.getName(), user.getSurname(),
                user.getEmail(), user.getPassword(), user.getRePassword()));
    }

    @PostMapping("/register-dto")
    public ResponseEntity<RegisterResponseDto> registerDto(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }

    @PostMapping("/register-mapper")
    public ResponseEntity<RegisterResponseDto> registerMapper(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerMapper(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(String email, String password){
        return ResponseEntity.ok(userService.login(email, password));
    }

    @PostMapping("login-dto")
    public ResponseEntity<LoginResponseDto> loginDto(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.loginDto(dto));
    }

    @PostMapping("login-mapper")
    public ResponseEntity<LoginResponseDto> loginMapper(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @GetMapping("order-by-name")
    public ResponseEntity<List<User>> findAllByOrderByName(){
        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/exists-by-name")
    public ResponseEntity<Boolean> existsByName(String name){
        return ResponseEntity.ok(userService.existsByName(name));
    }

    @GetMapping("/find-by-name-containing")
    public ResponseEntity<List<RegisterResponseDto>> findByNameContaining(String name){
        return ResponseEntity.ok(userService.findByNameContaining(name));
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<Optional<RegisterResponseDto>> findByEmail(String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
}
