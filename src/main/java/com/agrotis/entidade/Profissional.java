package com.agrotis.entidade;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "profissional")
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String observacoes;
    private Date dataInicial;
    private Date dataFinal;

    private String cnpj;

    @OneToOne
    //@JoinTable(name="profissional_propriedade", joinColumns = {@JoinColumn(name="profissional_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name="propriedade_id", referencedColumnName = "id")})
    private Propriedade propriedade;

    @OneToOne
    //@JoinTable(name="profissional_laboratorio", joinColumns = {@JoinColumn(name="profissional_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name="laboratorio_id", referencedColumnName = "id")})
    private Laboratorio laboratorio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "Profissional{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", idPropriedade=" + laboratorio +
                ", idLaboratorio=" + laboratorio +
                '}';
    }
}

