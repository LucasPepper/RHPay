package br.edu.ifnmg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

/*      Faixa Salarial          |   Aliquota
** 1ª) ATÉ 1100                 |    7.5%
** 2ª) 1100.01 até 2203.48      |    9%
** 3ª) 2203.49 até 3305.22      |    12%
** 4ª) 3305.23 até 6433.57      |    14%
*  5ª) ACIMA DE 6433.57         |   TETO DE R$751,99
 */
// https://www.contabilizei.com.br/contabilidade-online/desconto-inss/
@Entity
@DiscriminatorValue("INSS")
public class INSS extends DebitoMensal implements Serializable {
    public static final BigDecimal ALIQUOTA_PRIMEIRA_FAIXA_SALARIAL = BigDecimal.valueOf(0.075);
    public static final BigDecimal ALIQUOTA_SEGUNDA_FAIXA_SALARIAL = BigDecimal.valueOf(0.09);
    public static final BigDecimal ALIQUOTA_TERCEIRA_FAIXA_SALARIAL = BigDecimal.valueOf(0.12);
    public static final BigDecimal ALIQUOTA_QUARTA_FAIXA_SALARIAL = BigDecimal.valueOf(0.14);
    public static final BigDecimal TETO_QUINTA_FAIXA_SALARIAL = BigDecimal.valueOf(751.99);

}
