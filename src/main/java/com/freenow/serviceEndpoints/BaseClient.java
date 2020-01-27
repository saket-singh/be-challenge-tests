package com.freenow.serviceEndpoints;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseClient {

    protected ObjectMapper mapper;

    public BaseClient() {
        mapper = new ObjectMapper();
    }
}
