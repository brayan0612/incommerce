package com.example.auth.infrastructure.mapper;

import com.example.auth.domain.model.Usuario;
import com.example.auth.infrastructure.driver_adapters.UsuarioData;
import org.springframework.stereotype.Component;


@Component
public class UsuarioMapper {
    public Usuario toUsuario(UsuarioData usuarioData){
        return new Usuario(
                usuarioData.getIdusuario(),
                usuarioData.getNombre(),
                usuarioData.getEmail(),
                usuarioData.getPass(),
                usuarioData.getRole(),
                usuarioData.getEdad(),
                usuarioData.getNumeroTelefono()
        );
    }
    public UsuarioData toUsuarioData (Usuario usuario){
        return new UsuarioData(
                usuario.getIdusuario(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPass(),
                usuario.getRole(),
                usuario.getEdad(),
                usuario.getNumeroTelefono()

                );
    }

}


