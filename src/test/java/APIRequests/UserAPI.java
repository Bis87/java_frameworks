package APIRequests;

import APITests.ListUsersTest;
import dto.User;
import dto.UserList;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class UserAPI extends BaseAPIRequest{
    static Logger log = LogManager.getLogger(UserAPI.class.getName());

    public static User getUser(String userId){
        Response r =get(baseSpec(), "/users/"+userId);
        log.info("get user status code");
        log.info(r.statusCode());
//        r.body().prettyPrint();
//        System.out.println(r.jsonPath().get("data").toString());
        return r.jsonPath().getObject("data", User.class);
    }

    public static User postUser(User user){
        Response r =post(baseSpec().setBody(user), "/users/");
        return r.as(User.class);
    }

    public static UserList getUsers(String pageNumber){
        baseSpec().addParam("pagge", pageNumber);
        Response r =get(baseSpec(), "/users").then().statusCode(200).extract().response();
        return r.as(UserList.class);
    }
}
