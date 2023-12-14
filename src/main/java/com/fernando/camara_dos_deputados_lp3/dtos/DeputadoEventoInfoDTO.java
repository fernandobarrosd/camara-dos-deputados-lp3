package com.fernando.camara_dos_deputados_lp3.dtos;

public class DeputadoEventoInfoDTO {
    private String nome;
    private String dataHoraInicio;
    private String dataHoraFim;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataHoraInicio() {
        return dataHoraInicio;
    }
    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }
    public String getDataHoraFim() {
        return dataHoraFim;
    }
    public void setDataHoraFim(String dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    
}
