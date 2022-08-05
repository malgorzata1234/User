package com.user.user_panel.business.user.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
public class UserDto {

    private int id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private BigDecimal calculations;
}
