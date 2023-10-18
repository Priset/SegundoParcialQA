package api.apiTest.filaA;

import api.factoryRequest.FactoryRequest;
import api.factoryRequest.RequestInfo;
import api.utils.Properties;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

public class EJercicio2Test {
    RequestInfo requestInfo = new RequestInfo();
    Response response;
    String auth;
    String[] projectsContent = {
            "UPB QA 1 " + new Date().getTime(),
            "UPB QA 2 " + new Date().getTime(),
            "UPB QA 3 " + new Date().getTime(),
            "UPB QA 4 " + new Date().getTime()
    };

    @BeforeEach
    public void setup() {
        auth = Base64.getEncoder().encodeToString((Properties.user+":"+Properties.pwd).getBytes());
    }

    @Test
    public void verifyEjercicio2Test(){
        for (int i = 0; i < 4; i++) {
            createProject(projectsContent[i]);
        }
        getProjects();
        deleteProjects();
    }

    private void createProject(String content) {
        requestInfo.setHost(Properties.host + "api/projects.json")
                .setBody("{\"Content\":\"" + content + "\"}")
                .setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("post").send(requestInfo);

        response.then().log().all().statusCode(200)
                .body("Content", equalTo(content));
    }

    private void getProjects() {
        requestInfo.setHost(Properties.host + "api/projects.json")
                .setHeader("Authorization", "Basic " + auth);

        response = FactoryRequest.make("get").send(requestInfo);

        response.then().log().all().statusCode(200);
    }

    public void deleteProjects() {
        JSONArray jsonArray = new JSONArray(response.body().print());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("Id");

            requestInfo.setHost(Properties.host + "api/projects/" + id + ".json")
                    .setHeader("Authorization", "Basic " + auth);

            response = FactoryRequest.make("delete").send(requestInfo);

            response.then().log().all().statusCode(200)
                    .body("Id", equalTo(id))
                    .body("Deleted", equalTo(true));
        }
    }
}
