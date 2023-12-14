package com.fernando.camara_dos_deputados_lp3.mappers;

import com.fernando.camara_dos_deputados_lp3.dtos.EventoAPIDTO;
import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {
    public Evento toEntity(EventoAPIDTO eventoDTO) {
        EventoAPIDTO.Dados dados = eventoDTO.getDados();
        String nomeEvento = String.format("Evento#%d - %s", 
        dados.getId(), dados.getDescricaoTipo());

        return new Evento.Builder()
                .id(null)
                .dataHoraInicio(dados.getDataHoraInicio())
                .dataHoraFim(dados.getDataHoraFim())
                .nome(nomeEvento)
                .build();
    }
}