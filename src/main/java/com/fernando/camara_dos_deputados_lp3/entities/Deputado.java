package com.fernando.camara_dos_deputados_lp3.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "deputado")
public class Deputado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "nome_civil")
    private String nomeCivil;



    @Column(nullable = false, name = "sigla_partido")
    private String siglaPartido;

    @Column(nullable = false, name = "sigla_uf")
    private String siglaUF;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Evento> eventos;

    public Deputado() {
    }

    public Deputado(Long id, String nome, String nomeCivil,
                    String siglaPartido, String siglaUF,
                    List<Evento> eventos) {
        this.id = id;
        this.nome = nome;
        this.nomeCivil = nomeCivil;
        this.siglaPartido = siglaPartido;
        this.siglaUF = siglaUF;
        this.eventos = eventos;
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

    public String getNomeCivil() {
        return nomeCivil;
    }

    public void setNomeCivil(String nomeCivil) {
        this.nomeCivil = nomeCivil;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getSiglaUF() {
        return siglaUF;
    }

    public void setSiglaUF(String siglaUF) {
        this.siglaUF = siglaUF;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public static class Builder {
        private Deputado deputado;

        public Builder() {
            this.deputado = new Deputado();
        }

        public Builder id(Long id) {
            this.deputado.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            this.deputado.setNome(nome);
            return this;
        }

        public Builder nomeCivil(String nomeCivil) {
            this.deputado.setNomeCivil(nomeCivil);
            return this;
        }

        public Builder siglaPartido(String siglaPartido) {
            this.deputado.setSiglaPartido(siglaPartido);
            return this;
        }

        public Builder siglaUf(String siglaUf) {
            this.deputado.setSiglaUF(siglaUf);
            return this;
        }

        public Builder eventos(List<Evento> eventos) {
            this.deputado.setEventos(eventos);
            return this;
        }

        public Deputado build() {
            return this.deputado;
        }


    }
}