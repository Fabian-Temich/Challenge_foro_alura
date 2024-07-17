package com.challenge_foroalura.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface IUserRepository extends JpaRepository<Usuario, Long > {
    Optional<Usuario> findByUsername(String username);
}
