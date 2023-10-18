package api.factoryRequest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestDELETE implements IRequest {

    @Override
    public Response send(RequestInfo request) {
        Response r = given()
                .headers(request.getHeaders())
                .log().all()
                .when()
                .delete(request.getHost());
        r.then().log().all();
        return r;

    }
}
