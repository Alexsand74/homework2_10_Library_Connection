package com.example.homework2_10_library_connection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST) // не корректный запрос - ошибка номер 400
public class EmployeeAlreadyAddedException extends RuntimeException { //наследуемся от непроверяемого исключения

}
