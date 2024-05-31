package org.gmaoback.gmaomondi_backend.gestionEquipement.model;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // You can customize the configuration here if needed
        return modelMapper;
    }
}