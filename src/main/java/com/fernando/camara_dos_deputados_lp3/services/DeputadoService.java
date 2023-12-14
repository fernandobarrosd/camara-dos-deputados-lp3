package com.fernando.camara_dos_deputados_lp3.services;

import com.fernando.camara_dos_deputados_lp3.dtos.EventoInfoDTO;
import com.fernando.camara_dos_deputados_lp3.entities.Deputado;
import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import com.fernando.camara_dos_deputados_lp3.projections.DeputadoEventosProjection;
import com.fernando.camara_dos_deputados_lp3.repositories.DeputadoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeputadoService {
    @Autowired
    private DeputadoRepository deputadoRepository;

    @Autowired
    private EventoService eventoService;


    public List<Deputado> findAll() {
        return deputadoRepository.findAll();
    }


    public Deputado findByID(Long id) {
        return deputadoRepository.findById(id)
                .orElseThrow
                        (() -> new EntityNotFoundException("Deputado não encontrado"));
    }

    public List<EventoInfoDTO> findEventos(Long deputadoID) {
        DeputadoEventosProjection projection = deputadoRepository.findEventos(deputadoID)
                .orElseThrow
                        (() -> new EntityNotFoundException("Deputado não encontrado"));
        return projection.getEventos()
        .stream().map(evento -> new EventoInfoDTO(
            evento.getId(),
            evento.getNome(),
            evento.getDataHoraInicio(),
            evento.getDataHoraFim(),
            deputadoID
        )).toList();
    }

    public void insertEvento(Long deputadoID, Long eventoID) {
        Deputado deputado = findByID(deputadoID);
        Evento evento = eventoService.findByID(eventoID);

        List<Evento> eventos = deputado.getEventos();

        eventos.add(evento);
        deputado.setEventos(eventos);

        deputadoRepository.save(deputado);
    }

    public void deleteEvento(Long deputadoID, Long eventoID) {
        Deputado deputado = findByID(deputadoID);
        List<Evento> eventos = deputado.getEventos();

        eventos.removeIf(evento -> evento.getId() == eventoID);

        deputado.setEventos(eventos);

        deputadoRepository.save(deputado);
    }

    public EventoInfoDTO findEventoById(Long deputadoID, Long eventoID) {
        List<EventoInfoDTO> eventos = findEventos(deputadoID);
        return eventos.stream().filter(evento -> evento.getId() == eventoID)
        .findFirst().get();
    } 
}