package com.kulcorp.springbootstarter225.config;

import com.kulcorp.springbootstarter225.property.IncomeProperties;
import com.kulcorp.springbootstarter225.service.IncomeClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(IncomeProperties.class)
public class SpringStarterConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public IncomeClient genIncomeClient(IncomeProperties properties) {
        return new IncomeClient(new RestTemplate(), properties);
    }
}