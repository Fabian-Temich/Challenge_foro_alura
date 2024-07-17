package com.challenge_foroalura.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicesTopicos {

        @Autowired
        ITopicosRepository iTopicosRepository;

        public Topicos registrarTopicos(Topicos request){
            return iTopicosRepository.save(request);

        }
        public ArrayList<Topicos>listTopicos(){
            return (ArrayList<Topicos>) iTopicosRepository.findAll();
        }
        public Optional<Topicos>getTopicos(Long id){
            return iTopicosRepository.findById(id);
        }

        public Topicos updateTopicos(Long id, Topicos request){
            Topicos topicos = iTopicosRepository.findById(id).get();

            topicos.setUser_id(request.getUser_id());
            topicos.setCurso (request.getCurso());
            topicos.setTitulo(request.getTitulo());
            topicos.setMensaje(request.getMensaje());
            iTopicosRepository.save(topicos);
            return topicos;

        }

        public Boolean deleteTopicos(Long id){
            try {
                iTopicosRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }

}
