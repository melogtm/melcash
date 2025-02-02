package org.melogtm.melcash.domain.dto;

public record ClientRequest(
        String name,
        String cpf,
        String email,
        String password,
        String type,
        Double cash) {
}
