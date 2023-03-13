package io.programminglife.second_brain.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class NotionRequestUtil {

    private static final String NOTION_VERSION_HEADER_PARAM = "Notion-Version";
    private static final String X_COM_PERSIST_HEADER_PARAM = "X-COM-PERSIST";


    public ResponseEntity<String> get(String notionApiToken, String notionApiNotionVersion, String uri) {
        RestTemplate restTemplate = new RestTemplate();

        // this is a GET request, so we are setting up the headers
        HttpHeaders requestHeaders = headers(notionApiToken, notionApiNotionVersion);
        requestHeaders.set(X_COM_PERSIST_HEADER_PARAM, "NO");
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestHeaders);

        // retrieve and return the result
        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
    }

    public ResponseEntity<String> post(String notionApiToken, String notionApiNotionVersion, String uri) {
        RestTemplate restTemplate = new RestTemplate();

        // this is a POST request, so we are setting up the headers
        HttpHeaders requestHeaders = headers(notionApiToken, notionApiNotionVersion);

        // TODO we will send empty request body to start with
        HttpEntity<String> httpEntity = new HttpEntity<>("", requestHeaders);

        // retrieve and return the result
        return restTemplate.postForEntity(uri, httpEntity, String.class);
    }

    private HttpHeaders headers(String notionApiToken, String notionApiNotionVersion) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.setBearerAuth(notionApiToken);
        requestHeaders.set(NOTION_VERSION_HEADER_PARAM, notionApiNotionVersion);

        return requestHeaders;
    }

}
