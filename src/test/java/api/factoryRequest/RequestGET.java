package api.factoryRequest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest {

    @Override
    public Response send(RequestInfo request) {
        Response r = given()
                .headers(request.getHeaders())
                .log().all()
                .when()
                .get(request.getHost());
        r.then().log().all();
        return r;

    }
}
