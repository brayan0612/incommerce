package com.example.auth.infrastructure.driver_adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDataJpaRepositorio  extends JpaRepository<UsuarioData, String> {
    Optional<UsuarioData> findByEmail(String email);
}


