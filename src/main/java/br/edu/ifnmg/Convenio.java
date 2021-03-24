package br.edu.ifnmg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

// Recuperar o total gasto nas empresas conveniadas naquele mês e somar este total ao DebitoMensal
@Entity
@DiscriminatorValue("convenio")
public class Convenio extends DebitoMensal implements Serializable {
    private static List<Convenio> listaConvenios;
}
