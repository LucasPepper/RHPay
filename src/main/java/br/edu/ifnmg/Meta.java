package br.edu.ifnmg;

import br.edu.ifnmg.enums.EntidadeMeta;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// As Metas são referentes ao mês completo. Caso o funcionário/Setor alcançe uma determinada % de uma meta,
// ele receberá X% da bonificação referente àquela meta.
// OBS: As metas dos gerentes são relacionadas à Gerência daquele setor.
// Vendedores possuem metas relacionadas aos produtos que irão vender naquele mês.
// Os demais funcionários que recebem bonificações possuem metas relacionadas ao setor em que pertencem.
@Entity
//@Table(name = "metas")
@IdClass(Meta.class)
public class Meta implements Serializable {

    private static List<Meta> listaMetas;
    @Id
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private EntidadeMeta entidade;
    @Id
    // TODO: Verificar ID Funcionario/Setor
    private int funcionarioId;
    private int setorId;
    private String descricao;
    private BigDecimal valorObjetivo;
    private BigDecimal porcentagemMinimaValorObjetivo;
    private BigDecimal valorBonificacao;
    private BigDecimal valorAlcancado;

    // Construtor Meta Setor
    public Meta(LocalDate data, String descricao, EntidadeMeta entidade, int setorId, BigDecimal valorObjetivo,
                BigDecimal porcentagemMinimaValorObjetivo, BigDecimal valorBonificacao) {
        this.data = data;
        this.descricao = descricao;
        this.entidade = entidade;
        this.setorId = setorId;
        this.valorObjetivo = valorObjetivo;
        this.porcentagemMinimaValorObjetivo = porcentagemMinimaValorObjetivo;
        this.valorBonificacao = valorBonificacao;
    }

    public Meta() {

    }

    public Meta cadastrarMeta(){
        // Receber os dados
        if (this.entidade == EntidadeMeta.SETOR){
            // Inserir Setor
            return new Meta(data, descricao, entidade, setorId, valorObjetivo, porcentagemMinimaValorObjetivo, valorBonificacao);
        } else {
            // Inserir Funcionário
            return new Meta(data, descricao, entidade, funcionarioId, valorObjetivo, porcentagemMinimaValorObjetivo, valorBonificacao);
        }
    }

    public void setValorAlcancado(BigDecimal valorAlcancado) {
        this.valorAlcancado = valorAlcancado;
    }

    public BigDecimal getValorBonificacao() {
        return valorBonificacao;
    }

    public EntidadeMeta getEntidade() {
        return entidade;
    }

    /* Caso o funcionário/Setor alcançe a % Mínima do valor Objetivo de uma meta,
    ** ele receberá X% da bonificação referente àquela meta.
    ** Ex: Valor mínimo = 100.00. Valor Alcançado = 95.00. % Mínima = 90%. valorAlcancado / valorObjetivo >= %Mínima?
    */
    public void calcularValorBonificacao(){

        BigDecimal porcentagemMetaAlcancada = this.valorAlcancado.divide(this.valorObjetivo);

        // Se PorcentagemMetaAlcancada >= PorcentagemMinimaMeta
        if (porcentagemMetaAlcancada.compareTo(porcentagemMinimaValorObjetivo) >= 0){
            this.valorBonificacao = porcentagemMetaAlcancada.multiply(this.valorBonificacao);
        }
        else {
            this.valorBonificacao = BigDecimal.valueOf(0);
        }
    }

    // TODO: Acessar o HashMap de setores para recuperar a respectiva bonificação
    /*
    public void recuperarValorBonificacaoSetor(HashMap<Integer, Setor> mapaSetores){
        int idSetorPesquisado = this.getSetor().getId();
        if (this.getEntidade() == EntidadeMeta.SETOR){
            Setor setorPesquisado = mapaSetores.get(idSetorPesquisado);

            for(Funcionario funcionario : setorPesquisado.getListaFuncionarios()){
                this.funcionario = getFuncionario();
            }
        }
        System.out.printf("Setor %s : Bonificação %.2f", mapaSetores.get(idSetorPesquisado).getSetor(), this.getValorBonificacao());
    }
     */
}
