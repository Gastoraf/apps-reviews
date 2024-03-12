package ru.lab.authorization.service.service;

import ru.lab.authorization.service.entity.Role;
import ru.lab.authorization.service.entity.User;
import ru.lab.authorization.service.entity.dto.LoginUserDto;
import ru.lab.authorization.service.entity.dto.UserDto;
import ru.lab.authorization.service.entity.dto.RegisterUserDto;
import ru.lab.authorization.service.repository.RoleRepository;
import ru.lab.authorization.service.repository.UserRepository;
import ru.lab.authorization.service.service.exception.InvalidPasswordException;
import ru.lab.authorization.service.service.exception.InvalidUsernameException;
import ru.lab.authorization.service.service.exception.UserAlreadyExistsException;
import ru.lab.authorization.service.service.exception.UserNotFoundException;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@WebService(serviceName = "WebServiceAuthorization", portName = "AuthorizationPort", targetNamespace = "https://authorization.lab.ru")
public class AuthorizationServiceImpl implements AuthorizationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Pattern usernamePattern, passwordPattern;

    @Autowired
    public AuthorizationServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

        usernamePattern = Pattern.compile("^[\\p{L}\\p{N}\\p{P}\\p{Z}]{4,32}$");
        passwordPattern = Pattern.compile("^[\\p{L}\\p{N}\\p{P}\\p{Z}]{4,16}$");
    }

    @Override
    public UserDto register(RegisterUserDto userDto) throws UserAlreadyExistsException, InvalidUsernameException, InvalidPasswordException {
        // check
        Matcher validUsername = usernamePattern.matcher(userDto.getUsername());
        if (!validUsername.matches()) throw new InvalidUsernameException("Username invalid");
        Matcher validPassword = passwordPattern.matcher(userDto.getPassword());
        if (!validPassword.matches()) throw new InvalidPasswordException("Password invalid");
        User user = userDto.toUser();
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent()) throw new UserAlreadyExistsException("User already exists");
        // register
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setLastLogin(new Date());
        user = userRepository.save(user);
        // set roles
        Optional<Role> optionalRole = roleRepository.findByName("USER");
        Role role = optionalRole.orElse(new Role(1L, "USER"));
        user.setRoles(Collections.singleton(role));
        return UserDto.from(userRepository.save(user));
    }

    @Override
    public UserDto login(LoginUserDto userDto) throws UserNotFoundException, InvalidPasswordException {
        // check
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
        User user = optionalUser.orElseThrow(() ->
                new UserNotFoundException("user %s not found".formatted(userDto.getUsername()))
        );
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("password %s not correct".formatted(userDto.getPassword()));
        }
        // login
        user.setLastLogin(new Date());
        return UserDto.from(userRepository.save(user));
    }
}
