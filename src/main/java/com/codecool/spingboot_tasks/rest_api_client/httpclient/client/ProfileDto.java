package com.codecool.spingboot_tasks.rest_api_client.httpclient.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileDto {
    public Integer id;
    public String name;
    @JsonProperty("stargazers_count")
    public String stargazersCount;
    @JsonProperty("watchers_count")
    public String watchersCount;


}
