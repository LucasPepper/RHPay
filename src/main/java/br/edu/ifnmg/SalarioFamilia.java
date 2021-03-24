package br.edu.ifnmg;

// VALOR_COTA do Salário-Família: R$48.62 por filho com até 14 anos (ou superior para casos de invalidez/deficiência)
// Para receber este benefício, a RENDA_BRUTA do funcionário deve ser de até R$1425.56.

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("salario_familia")
public class SalarioFamilia extends CreditoMensal implements Serializable {
}
