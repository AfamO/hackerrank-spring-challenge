package com.hackerrank.sample.util;

import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration();
        configuration.setAmbiguityIgnored(true);
        configuration.setPropertyCondition(Conditions.isNotNull());
        configuration.setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
