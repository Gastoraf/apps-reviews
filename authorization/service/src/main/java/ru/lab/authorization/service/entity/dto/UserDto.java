package ru.lab.authorization.service.entity.dto;

import ru.lab.authorization.service.entity.User;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDto {

    private Long id;
    private String username;
    Set<RoleDto> roles;

    public static UserDto from(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles()
                .parallelStream()
                .map(role -> new RoleDto(role.getName()))
                .collect(Collectors.toSet()));
        return dto;
    }
}
