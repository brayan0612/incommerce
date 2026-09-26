package com.example.auth.infrastructure.driver_adapters;

import com.example.auth.domain.model.Usuario;
import com.example.auth.infrastructure.mapper.UsuarioMapper;
import com.example.auth.domain.model.getway.UsuarioGetway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor

public class UsuarioDataGatewayImpI implements UsuarioGetway {
    private final UsuarioMapper mapperUsuario;
    private final UsuarioDataJpaRepositorio repository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        UsuarioData usuarioData = mapperUsuario.toUsuarioData(usuario);
        return mapperUsuario.toUsuario(repository.save(usuarioData));
    }

    @Override
    public Usuario buscarPorId(String idusuario) {
        return repository.findById(idusuario)
                .map(mapperUsuario::toUsuario)
                .orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        UsuarioData usuarioData = mapperUsuario.toUsuarioData(usuario);
        return mapperUsuario.toUsuario(repository.save(usuarioData));
    }

    @Override
    public void eliminarPorId(String idusuario) {
        repository.deleteById(idusuario);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapperUsuario::toUsuario)
                .collect(Collectors.toList());
    }
}
