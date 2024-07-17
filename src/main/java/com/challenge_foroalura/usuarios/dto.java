package com.challenge_foroalura.usuarios;

public record dto(
        String name,
        String username,
        String password,
        Boolean enable
) {
}
