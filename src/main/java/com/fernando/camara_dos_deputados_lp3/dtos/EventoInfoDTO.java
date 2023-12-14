package com.fernando.camara_dos_deputados_lp3.dtos;

import java.time.LocalDateTime;

public class EventoInfoDTO {
    private Long id;
    private String nome;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Long deputadoID;

    public EventoInfoDTO() {
    }

    public EventoInfoDTO(Long id, String nome, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim,
            Long deputadoID) {
        this.id = id;
        this.nome = nome;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.deputadoID = deputadoID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Long getDeputadoID() {
        return deputadoID;
    }

    public void setDeputadoID(Long deputadoID) {
        this.deputadoID = deputadoID;
    }

}