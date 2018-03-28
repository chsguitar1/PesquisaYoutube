package br.edu.ifpr.pesquisa.model;

import com.orm.SugarRecord;

/**
 * Created by cristiano on 26/03/18.
 */

public class Resposta extends SugarRecord {
    String titulo;
    String resposta;
    Integer codigoPesquisa;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Integer getCodigoPesquisa() {
        return codigoPesquisa;
    }

    public void setCodigoPesquisa(Integer codigoPesquisa) {
        this.codigoPesquisa = codigoPesquisa;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "titulo='" + titulo + '\'' +
                ", resposta='" + resposta + '\'' +
                '}';
    }
}
