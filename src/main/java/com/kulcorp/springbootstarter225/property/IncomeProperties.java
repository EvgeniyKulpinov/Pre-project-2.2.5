package com.kulcorp.springbootstarter225.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "income")
@Getter
@Setter
public class IncomeProperties {

    private String url;
}
