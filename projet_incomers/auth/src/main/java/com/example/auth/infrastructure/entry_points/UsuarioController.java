package com.example.auth.infrastructure.entry_points;

import com.example.auth.domain.model.Usuario;
import com.example.auth.infrastructure.mapper.UsuarioMapper;
import com.example.auth.domain.usecase.UsuarioUseCase;
import com.example.auth.infrastructure.driver_adapters.UsuarioData;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ecommerce/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;
    private final UsuarioMapper mapperUsuario;

    @PostMapping("/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody UsuarioData usuarioData) {
        Usuario usuario = mapperUsuario.toUsuario(usuarioData);
        Usuario usuarioValidadoGuardado = usuarioUseCase.guardarUsuario(usuario);

        if (usuarioValidadoGuardado.getIdusuario() != null) {
            return new ResponseEntity<>(usuarioValidadoGuardado, HttpStatus.OK);
        }

        return new ResponseEntity<>(usuarioValidadoGuardado, HttpStatus.CONFLICT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioUseCase.obtenerTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // --- READ BY ID ---
    @GetMapping("/{idusuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String idusuario) {
        Usuario usuario = usuarioUseCase.obtenerPorId(idusuario);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // --- UPDATE ---
    @PutMapping("/update/{idusuario}")
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable String idusuario,
            @RequestBody UsuarioData usuarioData) {

        Usuario usuario = mapperUsuario.toUsuario(usuarioData);
        Usuario usuarioActualizado = usuarioUseCase.actualizarUsuario(idusuario, usuario);

        if (usuarioActualizado != null) {
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // --- DELETE BY ID ---
    @DeleteMapping("/delete/{idusuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String idusuario) {
        boolean eliminado = usuarioUseCase.eliminarPorId(idusuario);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
