package com.user.user_panel.business.user.boundary;

import com.user.user_panel.business.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(UserResources.USER_URI)
public class UserResources {

    static final String USER_URI = "/api/user";

    private final UserOperation userOperation;

    @GetMapping("/{login}")
    UserDto getUsersByLogin(@PathVariable String login) {
        return userOperation.getUser(login);
    }
}
