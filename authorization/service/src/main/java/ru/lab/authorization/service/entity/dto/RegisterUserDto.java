package ru.lab.authorization.service.entity.dto;

import ru.lab.authorization.service.entity.User;
import lombok.Data;

@Data
public class RegisterUserDto {

    private String username;
    private String password;
    private String imagePath;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setImagePath(imagePath);
        return user;
    }
}
