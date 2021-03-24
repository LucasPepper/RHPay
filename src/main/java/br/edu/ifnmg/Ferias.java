package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoDireitoTrabalhista;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

// A cada 12 meses trabalhados, o funcionário tem direito a 30 dias de férias remuneradas
// (1/3 do salário  + o salário mensal Adiantados)

// Data-Limite: as férias devem ser concedidas até 12 meses após completar 12 meses de trabalho.
@Entity
//@DiscriminatorValue("ferias")
public class Ferias extends DireitoTrabalhista implements Serializable {
    private static List<Ferias> listaFerias;

    public Ferias(TipoDireitoTrabalhista tipo, LocalDate data, int funcionarioId) {
        super(tipo, data, funcionarioId);
    }

    public Ferias() {

    }
}
