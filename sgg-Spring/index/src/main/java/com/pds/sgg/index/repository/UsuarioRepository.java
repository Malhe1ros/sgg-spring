package com.pds.sgg.index.repository;

import com.pds.sgg.index.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface do repositório das pessoas
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
