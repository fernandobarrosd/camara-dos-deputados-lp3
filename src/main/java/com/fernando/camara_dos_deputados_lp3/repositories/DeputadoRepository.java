package com.fernando.camara_dos_deputados_lp3.repositories;

import com.fernando.camara_dos_deputados_lp3.entities.Deputado;
import com.fernando.camara_dos_deputados_lp3.projections.DeputadoEventosProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {
    @Query("SELECT d FROM Deputado d WHERE d.id = :deputadoID")
    Optional<DeputadoEventosProjection> findEventos(
            @Param("deputadoID") Long deputadoID);
}