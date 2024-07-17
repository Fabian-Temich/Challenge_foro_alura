package com.challenge_foroalura.domain;

public record dto(
        Long usuario_id,
        String curso,
        String titulo,
        String mensaje,
        Boolean enable

) {
}
