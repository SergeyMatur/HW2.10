package com.example.hw2_10.service;

import com.example.hw2_10.exception.IncorrectNameException;
import com.example.hw2_10.exception.IncorrectSurnameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
class ValidatorService {
    public String validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            try {
                throw new IncorrectNameException();
            } catch (IncorrectNameException e) {
                throw new RuntimeException(e);
            }
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int i = 0; i < surnames.length; i++) {
            if (!StringUtils.isAlpha(surnames[i])) {
                try {
                    throw new IncorrectSurnameException();
                } catch (IncorrectSurnameException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return String.join("-", surnames);
    }
}
