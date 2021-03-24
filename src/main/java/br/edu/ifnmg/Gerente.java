package br.edu.ifnmg;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// Metas: de acordo com o Setor que gerencia. Ex: Perfumaria -> Média de Vendas de R$10.000 por cada funcionário
public class Gerente extends Funcionario {

    public Gerente(String nome, LocalDate dataNascimento, List<Documento> listaDocumentos,
                   List<Dependente> listaDependentes, LocalDate dataRegistro, int diasContratoExperiencia,
                   int setorId, String funcao, BigDecimal salarioBase) {
        super(nome, dataNascimento, listaDependentes, dataRegistro,
                diasContratoExperiencia, setorId, funcao, salarioBase);
    }
}
