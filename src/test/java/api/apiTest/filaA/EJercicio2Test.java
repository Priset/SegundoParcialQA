package api.apiTest.filaA;

import api.factoryRequest.FactoryRequest;
import api.factoryRequest.RequestInfo;
import api.utils.Properties;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Date;

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
        //getProjects();
        //deleteProjects();
    }

    private void createProject(String content) {
        requestInfo.setHost(Properties.host + "api/projects.json")
                .setBody("{\"Content\":\"" + content + "\"}")
                .setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("post").send(requestInfo);
    }
}
