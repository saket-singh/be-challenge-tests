package com.freenow.utility.request;

import com.freenow.utility.ServiceEndpoint;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;

import static io.restassured.RestAssured.given;

public class RequestHandler {

    public Response processRequest(ServiceEndpoint serviceEndpoint) {
        RestAssured.registerParser("text/plain", Parser.JSON);

        String url = serviceEndpoint.url();
        HttpMethod httpMethod = serviceEndpoint.httpMethod();
        RequestBody body = serviceEndpoint.body();
        String endpointName = serviceEndpoint.getClass().getSimpleName();

        RequestSpecification requestSpecification = formRequestSpecification(serviceEndpoint);

        logRequestDetails(serviceEndpoint, endpointName, url, httpMethod, body);
        Response response = makeAPIRequestAsPerHTTPMethod(url, httpMethod, requestSpecification);

        logResponseDetails(serviceEndpoint, endpointName, response);
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

    private void logRequestDetails(ServiceEndpoint serviceEndpoint, String endpointName, String url, HttpMethod httpMethod, RequestBody body) {
        Reporter.log(String.format("\n" + endpointName + " URL --- %s %s", httpMethod.toString(), url), true);

        if (serviceEndpoint.headers() != null) {
            for (Param p : serviceEndpoint.headers()) {
                Reporter.log(String.format(endpointName + " Header --- [ %s : %s ]", p.getKey(), p.getValue()), true);
            }
        }
        if (body != null)
            Reporter.log(String.format(endpointName + " Request --- %s", body.getBodyAsString()), true);
    }

    private void logResponseDetails(ServiceEndpoint serviceEndpoint, String endpointName, Response response) {
        Reporter.log(String.format(endpointName + " Response Status Code --- (%s)", response.getStatusCode()), true);

        if (serviceEndpoint.getClass() != null) {
            Reporter.log(String.format(endpointName + " Response --- %s", response.asString()), true);
        }
        Reporter.log(String.format("\n%s Response headers --- \n%s", endpointName, response.getHeaders().toString()), true);
    }
}
