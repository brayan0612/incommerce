package com.example.auth.application.config;
import com.example.auth.domain.model.getway.UsuarioGetway;
import com.example.auth.domain.usecase.UsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UseCaseConfig {
    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioGetway usuarioGateway){
        return new UsuarioUseCase(usuarioGateway);
    }
}
