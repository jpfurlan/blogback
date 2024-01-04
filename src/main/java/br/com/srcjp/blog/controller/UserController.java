package br.com.srcjp.blog.controller;

import br.com.srcjp.blog.dto.UserDto;
import br.com.srcjp.blog.dto.UserReadDto;
import br.com.srcjp.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserReadDto> createUser(@RequestBody UserDto userDto){
        UserReadDto userReadDto = userService.createUser(userDto);
        return new ResponseEntity<>(userReadDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReadDto> getUserById(@PathVariable Long id) {
        UserReadDto userReadDto = userService.getUserById(id);
        return ResponseEntity.ok(userReadDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReadDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserReadDto userReadDto = userService.updateUser(id, userDto);
        return ResponseEntity.ok(userReadDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
