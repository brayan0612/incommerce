package com.example.auth.domain.model.getway;

import com.example.auth.domain.model.Usuario;

import java.util.List;

public interface UsuarioGetway {
    Usuario guardarUsuario(Usuario usuario);
    Usuario buscarPorId(String idusuario);
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarPorId(String idusuario);
    List<Usuario> obtenerTodos();
}