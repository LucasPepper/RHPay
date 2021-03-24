package br.edu.ifnmg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

// Recuperar o total gasto em Crediário naquele mês e somar este total ao DebitoMensal
@Entity
@DiscriminatorValue("crediario")
public class Crediario extends DebitoMensal implements Serializable {
    private static List<Crediario> listaCrediarios;

}
