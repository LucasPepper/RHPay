package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoDebito;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_debito")
@IdClass(DebitoMensal.class)
public abstract class DebitoMensal implements Serializable {
    @Id
    protected int funcionarioId;
    @Id
    protected LocalDate data;
    protected TipoDebito tipo;
    protected BigDecimal valorTotal;

    public DebitoMensal() {
    }
}
