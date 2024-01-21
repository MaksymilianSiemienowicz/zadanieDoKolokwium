package com.example.demo.updaters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class RandomDataClient implements IRandomDataClient{

    @Value("${url}")
    private String url;

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<RandomPersonDto> getRandomPeople(int size) {
        String apiUrl = url.replace("{iloscDanych}", String.valueOf(size));
        return Collections.singletonList(restTemplate.getForObject(apiUrl, RandomPersonDto.class));
    }
}
