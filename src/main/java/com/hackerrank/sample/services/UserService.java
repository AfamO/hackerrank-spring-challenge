package com.hackerrank.sample.services;

import com.hackerrank.sample.dto.UserRequestDto;
import com.hackerrank.sample.dto.UserResponseDto;
import com.hackerrank.sample.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public UserResponseDto createUser(UserRequestDto userRequestDto);
    public UserResponseDto updateUser(UserRequestDto userRequestDto);

    public Page<User> getAllUsers(Pageable pageable);

    public UserResponseDto getSingleUser(Long id);

    Boolean removeAUser(Long id);
}
