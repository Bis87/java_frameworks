package APITests;

import APIRequests.UserAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dto.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class SingleUserTest extends BaseTest{

    static Logger log = LogManager.getLogger(SingleUserTest.class.getName());

    @Test
    public void testGetUser(){
        User u1 = UserAPI.getUser("2");
        User u2 = u1.toBuilder().id("666").email("HUZ@mail.cmm").build();

//        System.out.println(u1);
//        System.out.println("\n");
//        System.out.println(u2);

        SoftAssertions softAssert = new SoftAssertions();
        log.info("some message before verifications");
        softAssert.assertThat(u1.getId()).isEqualTo("2");
        softAssert.assertThat(u1.getId()).isEqualTo("71");
        softAssert.assertThat(u1.getFirst_name()).isEqualTo("Janet");
        softAssert.assertThat(u2.getEmail()).as("some description of what's going on").isEqualTo("HUZ@mail.cmmxcvCCC");
        softAssert.assertAll();

    }

    @Test
    public void testCreateUser() throws JsonProcessingException {
        User u1 = new User().toBuilder().name("BOB").job("BUILDER").build();
        User u1resp = UserAPI.postUser(u1);
        ObjectMapper mapper = new ObjectMapper();
//        JsonMapper mapper = new JsonMapper();
        log.info("RESPONSE u1resp");
//        System.out.println( u1resp.toString());
        log.info(mapper.writeValueAsString(u1resp));
    }
}
