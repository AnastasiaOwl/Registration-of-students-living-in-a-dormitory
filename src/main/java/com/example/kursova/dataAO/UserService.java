package com.example.kursova.dataAO;

import com.example.kursova.dto.UserDto;
import com.example.kursova.entities.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}