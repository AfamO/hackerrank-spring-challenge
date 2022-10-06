package com.hackerrank.sample.services;

import com.hackerrank.sample.dto.UserRequestDto;
import com.hackerrank.sample.dto.UserResponseDto;
import com.hackerrank.sample.exceptions.ConflictException;
import com.hackerrank.sample.exceptions.NotFoundException;
import com.hackerrank.sample.model.User;
import com.hackerrank.sample.repository.UserRepository;
import com.hackerrank.sample.util.Validations;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validations validations;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, Validations validations, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validations = validations;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        validations.validateUser(userRequestDto);
        if (userRepository.findByPhoneNumber(userRequestDto.getPhoneNumber()) != null)
            throw new ConflictException("409","This record already exists with the given phoneNumber");
        User user = modelMapper.map(userRequestDto,User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        validations.validateUser(userRequestDto);
        User user = userRepository.findById(userRequestDto.getId())
                .orElseThrow(()->new NotFoundException("404","The given Id doesn't exist and is thus not found"));
        user = modelMapper.map(userRequestDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserResponseDto.class);


    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserResponseDto getSingleUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("404", "The requested user with the id "+id+" doesn't exist"));
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public Boolean removeAUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("404"," Invalid userId"));
        userRepository.delete(user);
        return true;
    }
}
