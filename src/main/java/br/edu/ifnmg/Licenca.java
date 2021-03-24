package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoDireitoTrabalhista;

import java.time.LocalDate;

// Selecionar o Tipo da Licença, Alterar o Status. Em caso de Filhos, adicioná-los à lista de Dependentes (Salário Família)
public class Licenca extends DireitoTrabalhista{
    public Licenca(TipoDireitoTrabalhista tipo, LocalDate data, int funcionarioId) {
        super(tipo, data, funcionarioId);
    }
}
