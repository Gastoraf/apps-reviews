
package ru.lab.authorization.client;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.lab.authorization.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _Login_QNAME = new QName("http://service.service.authorization.lab.ru/", "login");
    private static final QName _LoginResponse_QNAME = new QName("http://service.service.authorization.lab.ru/", "loginResponse");
    private static final QName _Register_QNAME = new QName("http://service.service.authorization.lab.ru/", "register");
    private static final QName _RegisterResponse_QNAME = new QName("http://service.service.authorization.lab.ru/", "registerResponse");
    private static final QName _UserAlreadyExistsException_QNAME = new QName("http://service.service.authorization.lab.ru/", "UserAlreadyExistsException");
    private static final QName _InvalidUsernameException_QNAME = new QName("http://service.service.authorization.lab.ru/", "InvalidUsernameException");
    private static final QName _InvalidPasswordException_QNAME = new QName("http://service.service.authorization.lab.ru/", "InvalidPasswordException");
    private static final QName _UserNotFoundException_QNAME = new QName("http://service.service.authorization.lab.ru/", "UserNotFoundException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.lab.authorization.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Login }
     * 
     * @return
     *     the new instance of {@link Login }
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     * @return
     *     the new instance of {@link LoginResponse }
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     * @return
     *     the new instance of {@link Register }
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     * @return
     *     the new instance of {@link RegisterResponse }
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link UserAlreadyExistsException }
     * 
     * @return
     *     the new instance of {@link UserAlreadyExistsException }
     */
    public UserAlreadyExistsException createUserAlreadyExistsException() {
        return new UserAlreadyExistsException();
    }

    /**
     * Create an instance of {@link InvalidUsernameException }
     * 
     * @return
     *     the new instance of {@link InvalidUsernameException }
     */
    public InvalidUsernameException createInvalidUsernameException() {
        return new InvalidUsernameException();
    }

    /**
     * Create an instance of {@link InvalidPasswordException }
     * 
     * @return
     *     the new instance of {@link InvalidPasswordException }
     */
    public InvalidPasswordException createInvalidPasswordException() {
        return new InvalidPasswordException();
    }

    /**
     * Create an instance of {@link UserNotFoundException }
     * 
     * @return
     *     the new instance of {@link UserNotFoundException }
     */
    public UserNotFoundException createUserNotFoundException() {
        return new UserNotFoundException();
    }

    /**
     * Create an instance of {@link RegisterUserDto }
     * 
     * @return
     *     the new instance of {@link RegisterUserDto }
     */
    public RegisterUserDto createRegisterUserDto() {
        return new RegisterUserDto();
    }

    /**
     * Create an instance of {@link UserDto }
     * 
     * @return
     *     the new instance of {@link UserDto }
     */
    public UserDto createUserDto() {
        return new UserDto();
    }

    /**
     * Create an instance of {@link RoleDto }
     * 
     * @return
     *     the new instance of {@link RoleDto }
     */
    public RoleDto createRoleDto() {
        return new RoleDto();
    }

    /**
     * Create an instance of {@link LoginUserDto }
     * 
     * @return
     *     the new instance of {@link LoginUserDto }
     */
    public LoginUserDto createLoginUserDto() {
        return new LoginUserDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Login }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Register }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAlreadyExistsException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserAlreadyExistsException }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "UserAlreadyExistsException")
    public JAXBElement<UserAlreadyExistsException> createUserAlreadyExistsException(UserAlreadyExistsException value) {
        return new JAXBElement<>(_UserAlreadyExistsException_QNAME, UserAlreadyExistsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidUsernameException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidUsernameException }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "InvalidUsernameException")
    public JAXBElement<InvalidUsernameException> createInvalidUsernameException(InvalidUsernameException value) {
        return new JAXBElement<>(_InvalidUsernameException_QNAME, InvalidUsernameException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidPasswordException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidPasswordException }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "InvalidPasswordException")
    public JAXBElement<InvalidPasswordException> createInvalidPasswordException(InvalidPasswordException value) {
        return new JAXBElement<>(_InvalidPasswordException_QNAME, InvalidPasswordException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotFoundException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserNotFoundException }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.authorization.lab.ru/", name = "UserNotFoundException")
    public JAXBElement<UserNotFoundException> createUserNotFoundException(UserNotFoundException value) {
        return new JAXBElement<>(_UserNotFoundException_QNAME, UserNotFoundException.class, null, value);
    }

}
