package com.challenge_foroalura.autenticacion;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegisterRequest {
    String name;
    String username;
    String password;
    Boolean enable;


}
