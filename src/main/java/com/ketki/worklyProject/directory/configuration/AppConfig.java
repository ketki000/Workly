package com.ketki.worklyProject.directory.configuration;

import com.ketki.worklyProject.directory.DB;
import com.ketki.worklyProject.directory.DevDB;
import com.ketki.worklyProject.directory.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean(){
    return new DevDB();
}

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean(){return new ProdDB();}

    //Model Mapper configuration
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
