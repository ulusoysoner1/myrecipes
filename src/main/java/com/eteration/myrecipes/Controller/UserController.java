package com.eteration.myrecipes.Controller;

import com.eteration.myrecipes.Dto.UserDto;
import com.eteration.myrecipes.Entity.User;
import com.eteration.myrecipes.Service.Abstract.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ModelMapper modelMapper;

    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok().body(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        User userRequest = modelMapper.map(userDto, User.class);
        User user = userService.createUser(userRequest);

        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId, @RequestBody UserDto userDto) {

        User userRequest = modelMapper.map(userDto, User.class);

        User user = userService.updateUser(userId, userRequest);

        // entity to DTO
        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok().body(userResponse);
    }
}
