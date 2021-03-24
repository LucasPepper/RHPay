package br.edu.ifnmg;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

/* As Metas são referentes ao mês completo. Caso o funcionário/Setor alcançe uma determinada % de uma meta,
   ele receberá X% da bonificação referente àquela meta.
   OBS: As metas dos gerentes são relacionadas à Gerência daquele setor.
   Vendedores possuem metas relacionadas aos produtos que irão vender naquele mês.
   Os demais funcionários que recebem bonificações possuem metas relacionadas ao setor em que pertencem.
 */
@Entity
@DiscriminatorValue("bonificacao")
public class Bonificacao extends CreditoMensal implements Serializable {
    @Transient
    private Meta metaReferencia;
    public BigDecimal recuperarValorBonificacaoFuncionario(){
        return this.metaReferencia.getValorBonificacao();
    }

}
