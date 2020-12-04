package spring.boot.parser.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Data;
import spring.boot.parser.model.Role;

@Builder
@Data
public class UserResponseDto {
    private Long id;
    private String userId;
    private String profileName;
    private Set<Role> role;
}
