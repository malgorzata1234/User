package com.user.user_panel.business.user.boundary;

import com.user.user_panel.business.user.control.GitHubApi;
import com.user.user_panel.business.user.control.UserDtoMapper;
import com.user.user_panel.business.user.control.UserRepository;
import com.user.user_panel.business.user.model.UserDto;
import com.user.user_panel.business.user.model.UserEntity;
import com.user.user_panel.system.NotFoundException;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOperation {

    private final GitHubApi githubApi;
    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;

    public UserDto getUser(String login) {
        countServiceCalls(login);

        return Try.of(() -> githubApi.getUserDetails(login).execute())
                .map(Response::body)
                .map(userDtoMapper::map)
                .getOrElseThrow(NotFoundException::new);
    }

    private void countServiceCalls(String login) {
        var user = userRepository.findByLogin(login);

        if (user == null) {
            user = UserEntity.builder().login(login).requestCount(1).build();
            userRepository.save(user);
            log.info("User with login: '{}' and request_count: '{}' successfully created in database", login, 1);
        } else {
            user.setRequestCount(user.getRequestCount() + 1);
            userRepository.saveAndFlush(user);
            log.info("User with login: '{}' and request_count: '{}' successfully updated in database", login, user.getRequestCount());
        }
    }
}
