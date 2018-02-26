package com.example.msa.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin

public class User {

    public static List<UserDTO> userDTOSet ;
    static {
        userDTOSet = new ArrayList<>();
        UserDTO u1 = new UserDTO();
        u1.setId(0);
        u1.setName("ali");
        u1.setPassword("ali");
        userDTOSet.add(u1);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserResponseDTO> helloWorld(@RequestBody UserLoginDTO userLogin) {
        for (UserDTO userDto:userDTOSet) {
            if (userLogin.getLogin().equals(userDto.getName()) && userLogin.getPassword().equals(userDto.getPassword())){
                return ResponseEntity.ok( new UserResponseDTO(userDto));
            }
        }
        return ResponseEntity.ok( new UserResponseDTO(null));
    }
    @RequestMapping(value = "/getusers", method = RequestMethod.POST)
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for (UserDTO userDto:userDTOSet) {
                userResponseDTOS.add(new UserResponseDTO(userDto));
        }
        return ResponseEntity.ok( userResponseDTOS);
     }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserLoginDTO userLogin) {
        UserDTO u = new UserDTO();
        u.setPassword(userLogin.getPassword());
        u.setId(userDTOSet.size());
        u.setName(userLogin.getLogin());
         userDTOSet.add(u);
        return ResponseEntity.ok(new UserResponseDTO(u));
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public ResponseEntity<UserResponseDTO> deleteUser(@RequestBody DeleteUserDTO userLogin) {
        if (userLogin.getUserId() < userDTOSet.size()){
            userDTOSet.remove(userLogin.getUserId());
            UserResponseDTO u = new UserResponseDTO(null);
            u.setSuccess(true);
            return ResponseEntity.ok(u);
        }
        return ResponseEntity.ok(new UserResponseDTO(null));
    }
}
