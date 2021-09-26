package com.codecool.spingboot_tasks.rest_api_client.httpclient.client;

import lombok.*;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Owner {

public String login;
public Integer id;
public String nodeId;
public String avatarUrl;
public String gravatarId;
public String url;
public String htmlUrl;
public String followersUrl;
public String followingUrl;
public String gistsUrl;
public String starredUrl;
public String subscriptionsUrl;
public String organizationsUrl;
public String reposUrl;
public String eventsUrl;
public String receivedEventsUrl;
public String type;
public Boolean siteAdmin;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}