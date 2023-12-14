package com.fernando.camara_dos_deputados_lp3.repositories;

import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import com.fernando.camara_dos_deputados_lp3.projections.EventoNomeIDProjection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    @Query("SELECT e FROM Evento e")
    List<EventoNomeIDProjection> findAllNomeAndId();
}