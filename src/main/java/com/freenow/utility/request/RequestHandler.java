package com.freenow.utility.request;

import com.freenow.utility.ServiceEndpoint;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestHandler {

    public Response processRequest(ServiceEndpoint serviceEndpoint) {
        RestAssured.registerParser("text/plain", Parser.JSON);

        String url = serviceEndpoint.url();
        HttpMethod httpMethod = serviceEndpoint.httpMethod();
        RequestBody body = serviceEndpoint.body();

        RequestSpecification requestSpecification = formRequestSpecification(serviceEndpoint);

        Response response = makeAPIRequestAsPerHTTPMethod(url, httpMethod, requestSpecification);

        return response;
    }

    private Response makeAPIRequestAsPerHTTPMethod(String url, HttpMethod httpMethod, RequestSpecification requestSpecification) {
        Response response = null;
        switch (httpMethod) {
            case GET:
                response = requestSpecification.get(url);
                break;
            case POST:
                response = requestSpecification.post(url);
                break;
            case PUT:
                response = requestSpecification.put(url);
                break;
            case PATCH:
                response = requestSpecification.patch(url);
                break;
            case DELETE:
                response = requestSpecification.delete(url);
        }

        return response;
    }

    private RequestSpecification formRequestSpecification(ServiceEndpoint serviceEndpoint) {
        RequestSpecification request = given();
        if (serviceEndpoint.headers() != null) {
            serviceEndpoint.headers().forEach(h -> request.header(h.getKey(), h.getValue()));
        }
        if (serviceEndpoint.pathParameters() != null) {
            serviceEndpoint.pathParameters().forEach(p -> request.pathParam(p.getKey(), p.getValue()));
        }
        if (serviceEndpoint.queryParameters() != null) {
            serviceEndpoint.queryParameters().forEach(q -> request.queryParam(q.getKey(), q.getValue()));
        }

        if (serviceEndpoint.body() != null)
            request.body(serviceEndpoint.body().getBodyAsString());

        return request;
    }
}
