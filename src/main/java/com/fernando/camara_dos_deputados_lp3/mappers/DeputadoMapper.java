package com.fernando.camara_dos_deputados_lp3.mappers;

import com.fernando.camara_dos_deputados_lp3.dtos.DeputadoAPIDTO;
import com.fernando.camara_dos_deputados_lp3.entities.Deputado;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DeputadoMapper {
    public Deputado toEntity(DeputadoAPIDTO deputadoDTO) {
        DeputadoAPIDTO.Dados dados = deputadoDTO.getDados();
        DeputadoAPIDTO.Dados.Status status = dados.getUltimoStatus();

        return new Deputado.Builder()
                .id(dados.getId())
                .nome(status.getNome())
                .nomeCivil(dados.getNomeCivil())
                .siglaPartido(status.getSiglaPartido())
                .siglaUf(status.getSiglaUf())
                .eventos(List.of())
                .build();
    }
}
