package br.edu.ifnmg;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// Até o 5º dia útil do mês: Somar os créditos e subtrair dos débitos
//TODO: Como juntar as tabelas CreditoMensal com DebitoMensal
@Entity
//@Table(name = "folhas_pagamentos")
@IdClass(FolhaPagamento.class)
public class FolhaPagamento implements Serializable {
    @Id
    private int funcionarioId;
    @Id
    private LocalDate data;
    @Transient
    private List<CreditoMensal> listaCreditoMensals;
    @Transient
    private List<DebitoMensal> listaDebitoMensals;
    private BigDecimal valorLiquido;
}
