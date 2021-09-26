package com.codecool.spingboot_tasks.rest_api_client.httpclient.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        final HttpStatus statusCode = response.getStatusCode();
        final Series series = statusCode.series();
        if(series== Series.SERVER_ERROR){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while using http client");
        }else if (series == Series.CLIENT_ERROR){
            if(statusCode == HttpStatus.NOT_FOUND){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }else if(statusCode == HttpStatus.UNAUTHORIZED){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        }
    }
}
