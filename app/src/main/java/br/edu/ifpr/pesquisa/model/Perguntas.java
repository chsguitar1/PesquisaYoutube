package br.edu.ifpr.pesquisa.model;

import java.util.List;

/**
 * Created by cristiano on 26/03/18.
 */

public class Perguntas {
    String titulo;
    String[] questoes;

    public Perguntas(String titulo, String[] questoes) {
        this.titulo = titulo;
        this.questoes = questoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getQuestoes() {
        return questoes;
    }

    public void setQuestoes(String[] questoes) {
        this.questoes = questoes;
    }

    @Override
    public String toString() {
        return "Perguntas{" +
                "titulo='" + titulo + '\'' +
                ", questoes=" + questoes +
                '}';
    }
}
