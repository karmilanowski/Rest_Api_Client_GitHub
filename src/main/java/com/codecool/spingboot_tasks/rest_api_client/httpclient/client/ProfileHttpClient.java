package com.codecool.spingboot_tasks.rest_api_client.httpclient.client;

import com.codecool.spingboot_tasks.rest_api_client.httpclient.ProfileDto;
import com.codecool.spingboot_tasks.rest_api_client.httpclient.RemoteProfile;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class ProfileHttpClient implements RemoteProfile {

    private final RestTemplate restTemplate;
    private final String uri;

    @Override
    public List<ProfileDto> getProducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);
        try{
            ResponseEntity<List<ProfileDto>> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<ProfileDto>>() {
            });
            List<ProfileDto> body = response.getBody();
            return (body!=null) ? body : Collections.emptyList();
        } catch (ResourceAccessException e) {
            return Collections.emptyList();
        }
    }


}
