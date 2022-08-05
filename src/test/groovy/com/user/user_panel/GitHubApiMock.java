//package com.user.user_panel;
//
//import com.user.user_panel.business.user.control.GitHubApi;
//import com.user.user_panel.business.user.model.UserDetails;
//import retrofit2.Call;
//
//
//public class GitHubApiMock implements GitHubApi {
//
//    @Override
//    public Call<UserDetails> getUserDetails(String login) {
//        return (Call<UserDetails>) UserDetails.builder().name("test").login("login").build();
//    }
//}
