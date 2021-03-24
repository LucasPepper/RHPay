package br.edu.ifnmg;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// Particularidade: ComissãoVendas
public class Vendedor extends Funcionario {
    public Vendedor(String nome, LocalDate dataNascimento, List<Documento> listaDocumentos,
                    List<Dependente> listaDependentes, LocalDate dataRegistro, int diasContratoExperiencia,
                    int setorId, String funcao, BigDecimal salarioBase) {
        super(nome, dataNascimento, listaDependentes,
                dataRegistro, diasContratoExperiencia, setorId, funcao, salarioBase);
    }
}
