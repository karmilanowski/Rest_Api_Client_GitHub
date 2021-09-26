package com.codecool.spingboot_tasks.rest_api_client.service;

import com.codecool.spingboot_tasks.rest_api_client.httpclient.client.ProfileDto;
import com.codecool.spingboot_tasks.rest_api_client.httpclient.client.ProfileHttpClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProfileService {

    private ProfileHttpClient profileHttpClient;

    @EventListener(ApplicationReadyEvent.class)
    public void checkProfile(){
        List<ProfileDto> products = profileHttpClient.getProducts();
        Integer starCountSum = 0;
        Integer watchersCountSum = 0;
        for (ProfileDto product : products) {
                starCountSum += Integer.parseInt(product.getStargazersCount());
                watchersCountSum += Integer.parseInt(product.getWatchersCount());

        }

        System.out.println("Star Sum -> " + starCountSum);
        System.out.println("Watchers Sum -> " + watchersCountSum);
    }
}
