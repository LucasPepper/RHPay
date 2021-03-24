package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoCredito;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Entity
@Table(name = "creditos_mensais")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_credito")
@IdClass(CreditoMensal.class)
//TODO: Verificar normalização do BD
public abstract class CreditoMensal implements Serializable {
    @Id
    protected int funcionarioId;
    @Transient
    protected TipoCredito tipo;
    @Id
    protected LocalDate data;
    protected BigDecimal valorTotal;

    // quantDiasTrabalhados = Ultimo dia do Mes - Data Registro
    int recuperarQuantDiasTrabalhadosMesAnterior(Funcionario funcionario){
        int quantDiasTrabalhados = 0;

        LocalDate dataRegistroFuncionario = funcionario.dataRegistro;
        int numeroDiaRegistroFuncionario = dataRegistroFuncionario.getDayOfMonth();

        int numeroMesRegistroFuncionario = dataRegistroFuncionario.getMonthValue();
        int numeroMesAnterior = LocalDate.now().minusMonths(1).getMonthValue();

        // Se o funcionário entrou na empresa neste mês:
        if (numeroMesRegistroFuncionario == numeroMesAnterior){
            LocalDate ultimoDiaDoMes = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
            int numeroUltimoDiaDoMes = ultimoDiaDoMes.getDayOfMonth();
            quantDiasTrabalhados = numeroUltimoDiaDoMes - numeroDiaRegistroFuncionario + 1;
        } else{
            quantDiasTrabalhados = 30;
        }

        return quantDiasTrabalhados;
    }
}
