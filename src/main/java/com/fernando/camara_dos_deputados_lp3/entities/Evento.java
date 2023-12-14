package com.fernando.camara_dos_deputados_lp3.entities;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false, name = "data_hora_inicio")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME,
    pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, 
    pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime dataHoraFim;

    @Column(nullable = false)
    private String nome;

    public Evento() {
    }

    

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static class Builder {
        private Evento evento;

        public Builder() {
            this.evento = new Evento();
        }

        public Builder id(Long id) {
            this.evento.setId(id);
            return this;
        }

        public Builder dataHoraInicio(LocalDateTime dataHoraInicio) {
            this.evento.setDataHoraInicio(dataHoraInicio);
            return this;
        }

        public Builder dataHoraFim(LocalDateTime dataHoraFim) {
            this.evento.setDataHoraFim(dataHoraFim);
            return this;
        }

        public Builder nome(String nome) {
            this.evento.setNome(nome);
            return this;
        }

        public Evento build() {
            return this.evento;
        }
    }
}