package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoDireitoTrabalhista;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
//@Table(name = "direitos_trabalhistas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_direito")
@IdClass(DireitoTrabalhista.class)
public abstract class DireitoTrabalhista implements Serializable {
    @Id
    protected int funcionarioId;
    @Transient
    protected TipoDireitoTrabalhista tipo;
    @Id
    protected LocalDate data;

    public DireitoTrabalhista(){}

    public DireitoTrabalhista(TipoDireitoTrabalhista tipo, LocalDate data, int funcionarioId) {
        this.tipo = tipo;
        this.data = data;
        this.funcionarioId = funcionarioId;
    }

    public TipoDireitoTrabalhista getTipo() {
        return tipo;
    }
}
