package br.edu.ifnmg;

import br.edu.ifnmg.enums.TipoDocumento;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

// Criar: Selecionar um tipo e preencher os dados
@Entity
//@Table(name = "documentos")
public class Documento implements Serializable {
    @Id
    private int id;
    private int funcionarioId;
    private TipoDocumento tipo;
    private String valor;
    private LocalDate dataEmissao;
    private LocalDate dataValidade;

    public Documento(){}

    public Documento(TipoDocumento tipo, int funcionarioId, String valor,
                     LocalDate dataEmissao, LocalDate dataValidade) {
        this.tipo = tipo;
        this.funcionarioId = funcionarioId;
        this.valor = valor;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
    }

    public void criarDocumento(){
        Documento novoDocumento = new Documento(tipo, funcionarioId, valor, dataEmissao, dataValidade);
    }
}
