package com.fernando.camara_dos_deputados_lp3.dtos;

public class DeputadoAPIDTO {
    private Dados dados;

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public static class Dados {
        private Long id;
        private String nomeCivil;
        private Status ultimoStatus;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNomeCivil() {
            return nomeCivil;
        }

        public void setNomeCivil(String nomeCivil) {
            this.nomeCivil = nomeCivil;
        }


        public Status getUltimoStatus() {
            return ultimoStatus;
        }

        public void setUltimoStatus(Status ultimoStatus) {
            this.ultimoStatus = ultimoStatus;
        }

        public static class Status {
            private String nome;
            private String siglaPartido;
            private String siglaUf;

            private String urlFoto;

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public String getSiglaPartido() {
                return siglaPartido;
            }

            public void setSiglaPartido(String siglaPartido) {
                this.siglaPartido = siglaPartido;
            }

            public String getSiglaUf() {
                return siglaUf;
            }

            public void setSiglaUf(String siglaUf) {
                this.siglaUf = siglaUf;
            }

            public String getUrlFoto() {
                return urlFoto;
            }

            public void setUrlFoto(String urlFoto) {
                this.urlFoto = urlFoto;
            }
        }
    }
}
