package com.hackerrank.sample.util;

import com.hackerrank.sample.dto.UserRequestDto;
import org.springframework.stereotype.Component;

@Component
public class Validations {

    public void validateUser(UserRequestDto userRequestDto){
        if (userRequestDto.getPhoneNumber() == null || userRequestDto.getPhoneNumber().equals(" "))
            throw new NullPointerException("Please phone Number filed cannot be empty");
        if(userRequestDto.getFirstName() == null || userRequestDto.getFirstName().equals(" "))
            throw new NullPointerException("FirstName field cannot be empty");
        if(userRequestDto.getLastName() == null || userRequestDto.getLastName().equals(""))
            throw new NullPointerException("LastName field cannot be empty");
        if(userRequestDto.getDate() == null || userRequestDto.getDate().equals(""))
            throw new NullPointerException("Date field cannot be empty");
    }
}
