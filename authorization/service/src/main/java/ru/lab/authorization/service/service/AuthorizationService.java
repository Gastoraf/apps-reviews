package ru.lab.authorization.service.service;

import ru.lab.authorization.service.entity.dto.LoginUserDto;
import ru.lab.authorization.service.entity.dto.UserDto;
import ru.lab.authorization.service.entity.dto.RegisterUserDto;
import ru.lab.authorization.service.service.exception.InvalidPasswordException;
import ru.lab.authorization.service.service.exception.InvalidUsernameException;
import ru.lab.authorization.service.service.exception.UserAlreadyExistsException;
import ru.lab.authorization.service.service.exception.UserNotFoundException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface AuthorizationService {

    @WebMethod
    UserDto register(RegisterUserDto userDto) throws UserAlreadyExistsException, InvalidUsernameException, InvalidPasswordException;

    @WebMethod
    UserDto login(LoginUserDto userDto) throws UserNotFoundException, InvalidPasswordException;

}
