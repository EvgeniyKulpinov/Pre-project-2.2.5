package com.kulcorp.springbootstarter225.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class EnvPostProcessor implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader propertySourceLoader;

    public EnvPostProcessor() {
        this.propertySourceLoader = new YamlPropertySourceLoader();
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var resource = new ClassPathResource("default.yaml");
        PropertySource<?> propertySource;
        try {
            propertySource = propertySourceLoader.load("income", resource).get(0);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        environment.getPropertySources().addLast(propertySource);
    }
}
