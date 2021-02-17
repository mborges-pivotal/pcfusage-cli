package com.borgescloud.pcfusage;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import lombok.Data;

@ConfigurationProperties(CfucliConfiguration.PREFIX)
@Requires(property = CfucliConfiguration.PREFIX)
@Data
public class CfucliConfiguration {

    public static final String PREFIX = "cfucli";

    private String endpoint;
    
}
