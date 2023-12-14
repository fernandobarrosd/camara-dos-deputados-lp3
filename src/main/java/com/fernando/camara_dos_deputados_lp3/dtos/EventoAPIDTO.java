package com.fernando.camara_dos_deputados_lp3.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class EventoAPIDTO {
    private Dados dados;

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public static class Dados {
        private Long id;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime dataHoraInicio;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime dataHoraFim;
        private String descricaoTipo;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public String getDescricaoTipo() {
            return descricaoTipo;
        }

        public void setDescricaoTipo(String descricaoTipo) {
            this.descricaoTipo = descricaoTipo;
        }


    }
}
