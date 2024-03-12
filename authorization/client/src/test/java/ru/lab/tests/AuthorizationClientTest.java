package ru.lab.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.lab.authorization.client.*;

import static org.junit.Assert.assertEquals;


public class AuthorizationClientTest {

    private static AuthorizationService service;
    private static final String username = "Михаил";
    private static final String password = "Пароль1234";
    private static final String invalidUsername = "СлишкомДлинноеИмя с asd21-=+sa-d=!_++_=123;:!!!!!!!!dasd";
    private static final String invalidPassword = "СлишкомДлинныйПароль1234";

    @BeforeClass
    public static void setService() {
        WebServiceAuthorization webService = new WebServiceAuthorization();
        service = webService.getAuthorizationPort();
    }

    @Test
    public void registerUser_ValidData_Success() throws InvalidPasswordException_Exception, UserAlreadyExistsException_Exception, InvalidUsernameException_Exception {
        RegisterUserDto userRegDto = new RegisterUserDto();
        userRegDto.setUsername(username);
        userRegDto.setPassword(password);
        userRegDto.setImagePath("ссылка на аву");
        UserDto user = service.register(userRegDto);
        assertEquals(userRegDto.getUsername(), user.getUsername());
    }

    @Test(expected = UserAlreadyExistsException_Exception.class)
    public void registerUser_UserAlreadyExists_ThrowsException() throws UserAlreadyExistsException_Exception, InvalidUsernameException_Exception, InvalidPasswordException_Exception {
        RegisterUserDto userRegDto = new RegisterUserDto();
        userRegDto.setUsername(username);
        userRegDto.setPassword(password);
        userRegDto.setImagePath("ссылка на аву");
        UserDto user = service.register(userRegDto);
    }

    @Test(expected = InvalidUsernameException_Exception.class)
    public void registerUser_InvalidUsername_ThrowsException() throws UserAlreadyExistsException_Exception, InvalidUsernameException_Exception, InvalidPasswordException_Exception  {
        RegisterUserDto userRegDto = new RegisterUserDto();
        userRegDto.setUsername(invalidUsername);
        userRegDto.setPassword(password);
        userRegDto.setImagePath("ссылка на аву");
        UserDto user = service.register(userRegDto);
    }

    @Test(expected = InvalidPasswordException_Exception.class)
    public void registerUser_InvalidPassword_ThrowsException() throws UserAlreadyExistsException_Exception, InvalidUsernameException_Exception, InvalidPasswordException_Exception {
        RegisterUserDto userRegDto = new RegisterUserDto();
        userRegDto.setUsername(username);
        userRegDto.setPassword(invalidPassword);
        userRegDto.setImagePath("ссылка на аву");
        UserDto user = service.register(userRegDto);
    }

    @Test
    public void loginUser_ValidData_Success() throws UserNotFoundException_Exception, InvalidPasswordException_Exception {
        LoginUserDto userAuthDto = new LoginUserDto();
        userAuthDto.setUsername(username);
        userAuthDto.setPassword(password);
        UserDto user = service.login(userAuthDto);
        assertEquals(userAuthDto.getUsername(), user.getUsername());
    }

    @Test(expected = UserNotFoundException_Exception.class)
    public void loginUser_UserNotFound_ThrowsException() throws UserNotFoundException_Exception, InvalidPasswordException_Exception {
        LoginUserDto userAuthDto = new LoginUserDto();
        userAuthDto.setUsername(invalidUsername);
        userAuthDto.setPassword(password);
        UserDto user = service.login(userAuthDto);
        assertEquals(userAuthDto.getUsername(), user.getUsername());
    }

    @Test(expected = InvalidPasswordException_Exception.class)
    public void loginUser_InvalidPassword_ThrowsException() throws UserNotFoundException_Exception, InvalidPasswordException_Exception {
        LoginUserDto userAuthDto = new LoginUserDto();
        userAuthDto.setUsername(username);
        userAuthDto.setPassword(invalidPassword);
        UserDto user = service.login(userAuthDto);
        assertEquals(userAuthDto.getUsername(), user.getUsername());
    }

}