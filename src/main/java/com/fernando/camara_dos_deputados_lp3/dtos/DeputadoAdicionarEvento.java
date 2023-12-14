package com.fernando.camara_dos_deputados_lp3.dtos;

public class DeputadoAdicionarEvento {
    private Long eventoID;

    public DeputadoAdicionarEvento() {
    }

    public DeputadoAdicionarEvento(Long eventoID) {
        this.eventoID = eventoID;
    }

    public Long getEventoID() {
        return eventoID;
    }

    public void setEventoID(Long eventoID) {
        this.eventoID = eventoID;
    }
}
