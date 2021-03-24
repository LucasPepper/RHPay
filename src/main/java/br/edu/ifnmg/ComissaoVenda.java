package br.edu.ifnmg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue("comissao_venda")
@IdClass(ComissaoVenda.class)
public class ComissaoVenda extends CreditoMensal implements Serializable {
    private static List<ComissaoVenda> listaComissoes;
    @Transient
    private String produto;
    @Transient
    private BigDecimal valorVendido;
    @Transient
    private BigDecimal porcentagemComissao;

    public ComissaoVenda() {

    }

    // Comissão para TODOS os funcionários
    public ComissaoVenda(String produto, BigDecimal porcentagemComissao) {
        this.produto = produto;
        this.porcentagemComissao = porcentagemComissao;
    }

    // Comissão para um funcionário ESPECIFICO
    public ComissaoVenda(int funcionarioId, String produto, BigDecimal porcentagemComissao) {
        this.produto = produto;
        this.porcentagemComissao = porcentagemComissao;
    }



    // Comissão = valorVendido * porcentagemComissao
    public BigDecimal calcularValorComissao(){

        return this.valorVendido.multiply(this.porcentagemComissao);
    }
}
