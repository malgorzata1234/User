package com.user.user_panel.business.user.control;

import com.user.user_panel.business.user.model.UserDetailsResponse;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class UserCounter {
    protected BigDecimal calculate(UserDetailsResponse userDetailsResponse) {

        var followers = Option.of(BigDecimal.valueOf(userDetailsResponse.getFollowers())).getOrElse(BigDecimal.ZERO);
        var publicRepos = Option.of(BigDecimal.valueOf(userDetailsResponse.getPublicRepos())).getOrElse(BigDecimal.ZERO);

        return BigDecimal.valueOf(6).divide(followers, 5, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(2).add(publicRepos));
    }
}
