package com.user.user_panel.business.user.control;

import com.user.user_panel.business.user.model.UserDetailsResponse;
import com.user.user_panel.business.user.model.UserDto;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoMapper {
    private final UserCounter userCounter;

    public UserDto map(UserDetailsResponse userDetailsResponse) {

        return UserDto.builder()
                .id(Option.of(userDetailsResponse.getId()).getOrNull())
                .login(Option.of(userDetailsResponse.getLogin()).getOrNull())
                .name(Option.of(userDetailsResponse.getName()).getOrNull())
                .type(Option.of(userDetailsResponse.getType()).getOrNull())
                .avatarUrl(Option.of(userDetailsResponse.getAvatarUrl()).getOrNull())
                .createdAt(userDetailsResponse.getCreatedAt())
                .calculations(userCounter.calculate(userDetailsResponse))
                .build();
    }
}
