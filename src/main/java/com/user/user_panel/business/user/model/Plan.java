package com.user.user_panel.business.user.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Plan {

    private String name;
    private Integer space;
    private Integer privateRepos;
    private Integer collaborators;
}
