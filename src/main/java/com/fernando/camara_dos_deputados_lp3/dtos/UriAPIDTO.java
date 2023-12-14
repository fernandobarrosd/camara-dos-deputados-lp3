package com.fernando.camara_dos_deputados_lp3.dtos;

import java.util.List;

public class UriAPIDTO {
    private List<Info> dados;

    public List<Info> getDados() {
        return dados;
    }

    public void setDados(List<Info> dados) {
        this.dados = dados;
    }

    public static class Info {
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
}
