package br.edu.ifnmg;

import br.edu.ifnmg.enums.MotivoRescisao;
import br.edu.ifnmg.enums.TipoAvisoPrevio;
import br.edu.ifnmg.enums.TipoDireitoTrabalhista;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;

// TODO: Processo rescisório: Pagamento FGTS de acordo com o motivo e Acerto (Créditos - Débitos), finalizando com Alteração de Status
@Entity
@DiscriminatorValue("rescisao")
public class Rescisao extends DireitoTrabalhista implements Serializable {
    @Enumerated(EnumType.STRING)
    private MotivoRescisao motivo;
    @Enumerated(EnumType.STRING)
    private TipoAvisoPrevio tipoAvisoPrevio;

    public Rescisao(TipoDireitoTrabalhista tipo, LocalDate data, int funcionarioId,
                    MotivoRescisao motivo, TipoAvisoPrevio tipoAvisoPrevio) {
        super(tipo, data, funcionarioId);
        this.motivo = motivo;
        this.tipoAvisoPrevio = tipoAvisoPrevio;
    }

    public Rescisao() {

    }
}
