package br.edu.ifnmg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

// Recuperar o total gasto em Vales naquele mês e somar este total ao DebitoMensal
@Entity
@DiscriminatorValue("vales")
public class Vale extends DebitoMensal implements Serializable {
    private static List<Vale> listaVales;
}
