package com.vitorduarte.OrangeTalentsAPI.repository;

import com.vitorduarte.OrangeTalentsAPI.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);
}
