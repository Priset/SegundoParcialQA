package api.factoryRequest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestPUT implements IRequest {

    @Override
    public Response send(RequestInfo request) {
        Response r = given()
                .headers(request.getHeaders())
                .body(request.getBody())
                .log().all()
                .when()
                .put(request.getHost());
        r.then().log().all();
        return r;

    }
}
