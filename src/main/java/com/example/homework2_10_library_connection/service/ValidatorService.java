package com.example.homework2_10_library_connection.service;

import com.example.homework2_10_library_connection.exception.IncorrectNameException;
import com.example.homework2_10_library_connection.exception.IncorrectSurnameException;
import com.example.homework2_10_library_connection.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    public Employee validateNameSurname (String name, String surname, int department, double salary) {
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException();
        }
        if (!StringUtils.isAlpha(surname)) {
                throw new IncorrectSurnameException();
            }
        return new Employee(StringUtils.capitalize(name.toLowerCase()),
                           StringUtils.capitalize(surname.toLowerCase()),
                                                               department,
                                                                    salary);
    }
}
