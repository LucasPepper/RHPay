package br.edu.ifnmg;

import br.edu.ifnmg.enums.DescricaoSetor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Relevante ao cálculo de Metas
@Entity
@Table(name = "setores")
public class Setor implements Serializable {
    @Transient
    private List<Funcionario> listaFuncionarios;

    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private DescricaoSetor setor;

    public DescricaoSetor getSetor() {
        return setor;
    }

    public int getId() {
        return id;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
}
