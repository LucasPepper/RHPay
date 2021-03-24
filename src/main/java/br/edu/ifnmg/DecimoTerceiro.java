package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoDireitoTrabalhista;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

// Proporcional aos meses trabalhados.
// Ex: 1 mês trabalhado = (numeroMesesTrabalhados/12 * salarioBase) = 1/12 * salarioBase
@Entity
//@Table(name = "decimo_terceiros")
//@DiscriminatorValue("decimo_terceiro")
public class DecimoTerceiro extends DireitoTrabalhista implements Serializable {
    public DecimoTerceiro(TipoDireitoTrabalhista tipo, LocalDate data, int funcionarioId) {
        super(tipo, data, funcionarioId);
    }

    public DecimoTerceiro(){}

    //TODO: pesquisar o Funcionario referente ao funcionarioId
    /*
    public BigDecimal calcularDecimoTerceiro(){
        int numeroMesesTrabalhados = funcionario.recuperarNumeroMesesTrabalhadosNoAno();
        BigDecimal salarioBase = new BigDecimal(String.valueOf(funcionario.getSalarioBase()));

        BigDecimal decimoTerceiro = salarioBase.multiply(BigDecimal.valueOf(numeroMesesTrabalhados))
                .divideToIntegralValue(BigDecimal.valueOf(12));
        return decimoTerceiro;
    }
    */
}