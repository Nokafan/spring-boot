package spring.boot.parser.mapper;

import org.springframework.stereotype.Component;
import spring.boot.parser.dto.UserResponseDto;
import spring.boot.parser.model.User;

@Component
public class UserMapper {
    public UserResponseDto userToResponceDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .profileName(user.getProfileName())
                .role(user.getRole())
                .build();
    }
}
