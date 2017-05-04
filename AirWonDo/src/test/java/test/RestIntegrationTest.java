package test;

import com.google.gson.Gson;
import entity.Flight;
import org.junit.BeforeClass;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.AfterClass;
import org.junit.Test;
import test.utils.EmbeddedTomcat;

public class RestIntegrationTest {

    private static final int SERVER_PORT = 9999;
    private static final String APP_CONTEXT = "/seed";
    private static EmbeddedTomcat tomcat;

    public RestIntegrationTest() {
    }
    private static String securityToken;

    //Utility method to login and set the securityToken
    private static void login(String role, String password) {
        String json = String.format("{username: \"%s\", password: \"%s\"}", role, password);
        System.out.println(json);
        securityToken = given()
                .contentType("application/json")
                .body(json)
                .when().post("/api/login")
                .then()
                .extract().path("token");
        System.out.println("Token: " + securityToken);

    }

    private void logOut() {
        securityToken = null;
    }

//    @BeforeClass
//    public static void setUpBeforeAll() throws ServletException, MalformedURLException, LifecycleException {
//        tomcat = new EmbeddedTomcat();
//        tomcat.start(SERVER_PORT, APP_CONTEXT);
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = SERVER_PORT;
//        RestAssured.basePath = APP_CONTEXT;
//        RestAssured.defaultParser = Parser.JSON;
//    }
//
//    @AfterClass
//    public static void after() throws ServletException, MalformedURLException, LifecycleException, IOException {
//        tomcat.stop();
//    }
//
//    @Test
//    public void testRestNoAuthenticationRequired() {
//        given()
//                .contentType("application/json")
//                .when()
//                .get("/api/flights").then()
//                .statusCode(200)
//                .body("message", equalTo("result for all"));
//    }
//
//    @Test
//    public void testGetFlight() {
//        given()
//                .pathParam("id", 1)
//                .when().get("api/flights/{id}")
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(1));
//    }
//
//    @Test
//    public void testAddFlight() {
//        FlightFacade ff = new FlightFacade("pu_development");
//        Flight f = new Flight("title", "info", "more info");
//        given()
//                .contentType("application/json")
//                .header("Authorization", "Bearer " + securityToken)
//                .body(new Gson().toJson(b))
//                .when()
//                .post("api/book")
//                .then()
//                .statusCode(200);
//        List<Book> bookList = bf.getBooks();
//        int idToDelete = bookList.get(bookList.size() - 1).getId();
//
//    }

}
