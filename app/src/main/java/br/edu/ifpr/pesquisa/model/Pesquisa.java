package br.edu.ifpr.pesquisa.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * Created by cristiano on 26/03/18.
 */

public class Pesquisa extends SugarRecord {

    Date data;
    String disciplina;
    String colegio;
    @Unique
    Integer codigo;
    boolean status;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pesquisa{" +
                "data=" + data +
                ", disciplina='" + disciplina + '\'' +
                ", colegio='" + colegio + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
