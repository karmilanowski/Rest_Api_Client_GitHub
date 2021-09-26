package com.codecool.spingboot_tasks.rest_api_client.httpclient;


import com.codecool.spingboot_tasks.rest_api_client.httpclient.client.ProfileDto;
import java.util.List;

public interface RemoteProfile {

    List<ProfileDto> getProducts();
}
