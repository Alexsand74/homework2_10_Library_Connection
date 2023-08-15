package com.example.homework2_10_library_connection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) // внутренняя ошибка сервера - ошибка номер 500
public class EmployeeStorageIsFullException extends RuntimeException{ //наследуемся от непроверяемого исключения

}
