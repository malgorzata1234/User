package com.user.user_panel

import com.user.user_panel.business.user.boundary.UserOperation
import com.user.user_panel.system.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import spock.lang.Specification

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserEntityOperationsIT extends Specification {

    @Autowired
    private UserOperation usersOperation

    def "should get user's details from external API and map to User"() {
        when:
            def result = usersOperation
                .getUser("octocat")
        then:
            verifyAll {
                result?.login == "octocat"
                result?.id == 583231
                result?.name == "The Octocat"
                result?.type == "User"
                result?.avatarUrl == "https://avatars.githubusercontent.com/u/583231?v=4"
                result?.createdAt?.toString() == "2011-01-25T18:44:36Z"
            }
    }

    def "should return 404 user doesn't exist in external system "() {
        when:
            usersOperation.getUser("1111111111111111")
        then:
            thrown NotFoundException
    }
}
