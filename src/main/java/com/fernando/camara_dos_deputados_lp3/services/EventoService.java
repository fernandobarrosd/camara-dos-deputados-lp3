package com.fernando.camara_dos_deputados_lp3.services;

import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import com.fernando.camara_dos_deputados_lp3.projections.EventoNomeIDProjection;
import com.fernando.camara_dos_deputados_lp3.repositories.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoNomeIDProjection> findAllNomeAndId() {
        return eventoRepository.findAllNomeAndId();
    }

    public Evento findByID(Long eventoID) {
        return eventoRepository.findById(eventoID)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
    }

    public void updateEvento(Evento evento) {
        eventoRepository.save(evento);
    }




}