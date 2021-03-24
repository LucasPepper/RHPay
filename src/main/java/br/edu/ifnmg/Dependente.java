package br.edu.ifnmg;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

// Salário Família: proporcional ao nº de Filhos < 14 Anos e Dependentes (Invalidez)
//@Table(name = "dependentes")
@Entity
@IdClass(Dependente.class)
public class Dependente implements Serializable {
    @Id
    private int funcionarioId;
    @Id
    private String nome;
    private LocalDate dataNascimento;
    @Transient
    private List<Documento> listaDocumentos;
    private String deficiencia;

}
