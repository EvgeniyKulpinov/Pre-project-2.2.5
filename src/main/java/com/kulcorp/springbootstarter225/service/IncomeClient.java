package com.kulcorp.springbootstarter225.service;

import com.kulcorp.springbootstarter225.dto.UserDto;
import com.kulcorp.springbootstarter225.property.IncomeProperties;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IncomeClient {

    private final RestTemplate restTemplate;

    private final IncomeProperties properties;

    public IncomeClient(RestTemplate restTemplate, IncomeProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public double getIncome(long userId) {
        try {
            UserDto[] usres = restTemplate.getForObject(properties.getUrl(), UserDto[].class);
            return Arrays.stream(usres)
                    .filter(p -> p.getId().equals(userId))
                    .findFirst()
                    .get()
                    .getIncome();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
