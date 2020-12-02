package spring.boot.parser.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.parser.dto.UserResponseDto;
import spring.boot.parser.mapper.UserMapper;
import spring.boot.parser.service.UserService;

@RestController
@RequestMapping("/user")
public class UsersController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/active")
    public List<UserResponseDto> getTopActiveUsers(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit) {
        Pageable topUsers = PageRequest.of(page, limit);
        return userService.findTopActiveUsers(topUsers)
                .stream()
                .map(userMapper::userToResponceDto)
                .collect(Collectors.toList());
    }
}
