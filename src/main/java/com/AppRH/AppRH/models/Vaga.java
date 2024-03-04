package com.AppRH.AppRH.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter

@Entity
public class Vaga implements Serializable { //serializable transforma o arquivo em binário para poder trabalhar com ele
    private static final long serialVersionUID = 1L; //Atributo que faz o controle de versionamento. Verifica se a versão do objeto é compatível com a versão serializada

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gerador de id para cada vaga utilizando o parâmetro "código"
    private long codigo;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String data;

    @NotEmpty
    private String salario;

    @OneToMany(mappedBy = "vaga", cascade =  CascadeType.REMOVE) //quando uma vaga for deletada, será deletado também um candidato
    private List<Candidato> candidatos;

}
