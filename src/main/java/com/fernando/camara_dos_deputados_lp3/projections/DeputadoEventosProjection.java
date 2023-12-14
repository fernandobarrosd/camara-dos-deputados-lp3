package com.fernando.camara_dos_deputados_lp3.projections;

import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import java.util.List;


public interface DeputadoEventosProjection {
    List<Evento> getEventos();
    Seringa getNomeCivil();
}