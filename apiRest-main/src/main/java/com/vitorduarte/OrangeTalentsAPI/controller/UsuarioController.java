package com.vitorduarte.OrangeTalentsAPI.controller;

import com.vitorduarte.OrangeTalentsAPI.entities.Usuario;
import com.vitorduarte.OrangeTalentsAPI.repository.UsuarioRepository;
import com.vitorduarte.OrangeTalentsAPI.integration.ViaCepApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private ViaCepApi viaCepApi;

    public UsuarioController(UsuarioRepository usuarioRepository, ViaCepApi viaCepApi) {
        this.usuarioRepository = usuarioRepository;
        this.viaCepApi = viaCepApi;
    }

    @PostMapping(value = "/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario Save(@RequestBody final Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{nome}")
    public Usuario getUsuarioByNome(@PathVariable final String nome) {
        return usuarioRepository.findByNome(nome);
    }

}
