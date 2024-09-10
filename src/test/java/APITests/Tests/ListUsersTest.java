package APITests.Tests;

import APITests.Tests.APIRequests.UserAPI;
import APITests.Tests.dto.UserList;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
//import utils.CustomTestListener;

import static io.restassured.RestAssured.*;

//@Listeners(CustomTestListener.class)
public class ListUsersTest implements BaseTest {

    @Test
    public void testUsers(){
        UserList resp = UserAPI.getUsers("2");
        System.out.println(resp.toString());
    }

    @Test
    public void testUsersResponse(){
        String url = "https://reqres.in/api/users?page=2";
        given().contentType(ContentType.JSON).when().get(url)
                .then().statusCode(200).and().extract().response().prettyPrint();
    }


}
