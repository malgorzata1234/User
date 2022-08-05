package com.user.user_panel

import com.user.user_panel.business.user.boundary.UserOperation
import com.user.user_panel.business.user.control.GitHubApi
import com.user.user_panel.business.user.control.UserCounter
import com.user.user_panel.business.user.control.UserDtoMapper
import com.user.user_panel.business.user.control.UserRepository
import com.user.user_panel.business.user.model.UserDetailsResponse
import org.springframework.boot.test.context.SpringBootTest
import retrofit2.mock.Calls
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class UserEntityOperationsUT extends Specification {

    private GitHubApi gitHubApi = Mock()
    private UserCounter userCounter = new UserCounter()
    private UserDtoMapper userDtoMapper = new UserDtoMapper(userCounter)
    private UserRepository userRepository = Mock()

    @Subject
    UserOperation userOperation = new UserOperation(gitHubApi, userDtoMapper, userRepository)

    def "should proper count calculation field"() {
        given:
            gitHubApi.getUserDetails("login") >> Calls.response(userResponse)

        when:
            def result = userOperation.getUser("login")

        then:
            verifyAll {
                result?.calculations == BigDecimal.valueOf(4)
            }
    }

    def userResponse = UserDetailsResponse.builder()
        .followers(12)
        .publicRepos(6)
        .id(4)
        .login("login")
        .name("name")
        .type("type")
        .avatarUrl(null)
        .createdAt(null)
        .build()
}
