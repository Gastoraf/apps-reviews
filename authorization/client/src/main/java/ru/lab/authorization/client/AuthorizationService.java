
package ru.lab.authorization.client;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "AuthorizationService", targetNamespace = "http://service.service.authorization.lab.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AuthorizationService {


    /**
     * 
     * @param arg0
     * @return
     *     returns ru.lab.authorization.client.UserDto
     * @throws InvalidPasswordException_Exception
     * @throws InvalidUsernameException_Exception
     * @throws UserAlreadyExistsException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "register", targetNamespace = "http://service.service.authorization.lab.ru/", className = "ru.lab.authorization.client.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://service.service.authorization.lab.ru/", className = "ru.lab.authorization.client.RegisterResponse")
    public UserDto register(
        @WebParam(name = "arg0", targetNamespace = "")
        RegisterUserDto arg0)
        throws InvalidPasswordException_Exception, InvalidUsernameException_Exception, UserAlreadyExistsException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns ru.lab.authorization.client.UserDto
     * @throws InvalidPasswordException_Exception
     * @throws UserNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://service.service.authorization.lab.ru/", className = "ru.lab.authorization.client.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://service.service.authorization.lab.ru/", className = "ru.lab.authorization.client.LoginResponse")
    public UserDto login(
        @WebParam(name = "arg0", targetNamespace = "")
        LoginUserDto arg0)
        throws InvalidPasswordException_Exception, UserNotFoundException_Exception
    ;

}