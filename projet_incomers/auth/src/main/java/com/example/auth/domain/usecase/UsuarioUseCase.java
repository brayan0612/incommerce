package com.example.auth.domain.usecase;

import com.example.auth.domain.model.Usuario;
import com.example.auth.domain.model.getway.UsuarioGetway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class UsuarioUseCase {


    private final UsuarioGetway usuarioGetway;


    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioGetway.guardarUsuario(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioGetway.obtenerTodos();
    }

    public Usuario obtenerPorId(String idusuario) {
        return usuarioGetway.buscarPorId(idusuario);
    }

    public Usuario actualizarUsuario(String idusuario, Usuario usuarioActualizado) {
        Usuario existe = usuarioGetway.buscarPorId(idusuario);
        if (existe != null) {
            usuarioActualizado.setIdusuario(idusuario);
            return usuarioGetway.actualizarUsuario(usuarioActualizado);
        }
        return null;
    }

    public Usuario buscarPorIdUsuario(Long id) {
        return null;
    }

    public boolean eliminarPorId(String idusuario) {
        Usuario existe = usuarioGetway.buscarPorId(idusuario);
        if (existe != null) {
            usuarioGetway.eliminarPorId(idusuario);
            return true;
        }
        return false;
    }
    public Usuario actualizaUsuario(Usuario usuario) {
        return usuario;
    }


    public String guardarUsuario(String email, String pass) {
        return email;
    }
}

