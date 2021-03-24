package br.edu.ifnmg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*      Faixa Salarial               Aliquota
 ** 1ª) Até 1903.98             |    0%
 ** 2ª) 1.903,99 até 2.826,65   |    7.5%
 ** 3ª) 2.826,66 até 3.751,05   |    15%
 ** 4ª) 3.751,06 até 4.664,68   |    22.5%
 ** 5ª) Acima de 4664.69        |    27.5%
 */
@Entity
@DiscriminatorValue("IRRF")
public class IRRF extends DebitoMensal{
    public static final BigDecimal ALIQUOTA_PRIMEIRA_FAIXA_SALARIAL = BigDecimal.valueOf(0);
    public static final BigDecimal ALIQUOTA_SEGUNDA_FAIXA_SALARIAL = BigDecimal.valueOf(0.075);
    public static final BigDecimal ALIQUOTA_TERCEIRA_FAIXA_SALARIAL = BigDecimal.valueOf(0.15);
    public static final BigDecimal ALIQUOTA_QUARTA_FAIXA_SALARIAL = BigDecimal.valueOf(0.225);
    public static final BigDecimal ALIQUOTA_QUINTA_FAIXA_SALARIAL = BigDecimal.valueOf(0.275);

}
