package com.example.hw2_10.service;

import com.example.hw2_10.exception.IncorrectNameException;
import com.example.hw2_10.exception.IncorrectSurnameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
class ValidatorService {
    public String validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int i = 0; i < surnames.length; i++) {
            if (!StringUtils.isAlpha(surnames[i])) {
                throw new IncorrectSurnameException();
            }
        }
        return String.join("-", surnames);
    }
}
