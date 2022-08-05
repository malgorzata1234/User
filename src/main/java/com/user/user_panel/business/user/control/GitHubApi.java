package com.user.user_panel.business.user.control;

import com.user.user_panel.business.user.model.UserDetailsResponse;
import com.user.user_panel.system.NotFoundException;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi  {

    @GET("users/{login}")
    Call<UserDetailsResponse> getUserDetails(@Path("login") String login) throws NotFoundException;
}
