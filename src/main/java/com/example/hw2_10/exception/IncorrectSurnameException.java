package com.example.hw2_10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
public class IncorrectSurnameException extends Throwable {
}
