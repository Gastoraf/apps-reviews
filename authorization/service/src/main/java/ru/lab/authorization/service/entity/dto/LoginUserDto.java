package ru.lab.authorization.service.entity.dto;

import ru.lab.authorization.service.entity.User;
import lombok.Data;

@Data
public class LoginUserDto {

    private String username;
    private String password;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

}
