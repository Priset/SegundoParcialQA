package api.apiTest.filaA;

import api.factoryRequest.FactoryRequest;
import api.factoryRequest.RequestInfo;
import api.utils.Properties;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio1Test {
    RequestInfo requestInfo = new RequestInfo();
    Response response;
    String auth;
    JSONObject projectBody = new JSONObject();
    JSONObject userBody = new JSONObject();

    @BeforeEach
    public void setup(){
        userBody.put("FullName", "Karim");
        userBody.put("Email", "karim@gmail.com");
        userBody.put("Password", "karim1234");
        projectBody.put("Content", "UPB QA Priset" + new Date().getTime());
    }

    @Test
    public void verifyEjercicio1Test(){
        createUser();
        createProject();
        deleteUser();
        creatreProjectWithInvalidAuth();
    }

    private void createUser(){
        requestInfo.setHost(Properties.host + "api/user.json").setBody(userBody.toString());
        response = FactoryRequest.make("post").send(requestInfo);

        response.then().log().all().statusCode(200)
                .body("Email", equalTo(userBody.get("Email")))
                .body("FullName", equalTo(userBody.get("FullName")));

        auth = Base64.getEncoder().encodeToString((userBody.get("Email") + ":" + userBody.get("Password")).getBytes());
    }

    private void createProject(){
        requestInfo.setHost(Properties.host + "api/projects.json").setBody(projectBody.toString()).setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("post").send(requestInfo);

        response.then().log().all().statusCode(200)
                .body("Content", equalTo(projectBody.get("Content")));
    }

    private void deleteUser(){
        requestInfo.setHost(Properties.host +"api/user/0.json").setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("delete").send(requestInfo);

        response.then().log().all().statusCode(200)
                .body("Email", equalTo(userBody.get("Email")))
                .body("FullName", equalTo(userBody.get("FullName")));
    }

    private void creatreProjectWithInvalidAuth(){
        requestInfo.setHost(Properties.host + "api/projects.json").setBody(projectBody.toString()).setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("post").send(requestInfo);

        response.then().log().all().statusCode(200)
                .body("ErrorMessage", equalTo("Account doesn't exist"));
    }

}
