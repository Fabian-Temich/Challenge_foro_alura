package com.challenge_foroalura.usuarios;


import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Services {
    
    IUserRepository userRepository;
    
    public ArrayList<Usuario>listUsuarios(){
        return (ArrayList<Usuario>) userRepository.findAll();
    }
    
}
