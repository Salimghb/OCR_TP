package fr.orleans.miage.ocr.client.config;

import fr.orleans.miage.ocr.client.exceptions.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

    @Bean
    public CustomErrorDecoder myCustomErrorDecoder(){
        return new CustomErrorDecoder();
    }
}
