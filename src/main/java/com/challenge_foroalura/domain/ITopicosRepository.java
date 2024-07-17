package com.challenge_foroalura.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicosRepository extends JpaRepository<Topicos, Long> {


}
