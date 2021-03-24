package br.edu.ifnmg;

import br.edu.ifnmg.enums.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

// Registros essenciais: DATAS (Contrato, Demissão, Licenças, Férias, 13º)
// VALORES (SalárioBase, Débitos e Créditos)
// DOCUMENTOS
@Entity
public class Funcionario implements Serializable {
    public static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1000.00);

    @Id
    protected int id;
    protected String nome;
    protected LocalDate dataNascimento;
    protected LocalDate dataRegistro;
    protected int diasContratoExperiencia;
    protected LocalDate dataDemissao;
    //TODO: Como persistir o enum StatusFuncionario
    @Enumerated(EnumType.STRING)
    protected StatusFuncionario status;
    protected int setorId;
    protected String funcao;
    protected BigDecimal salarioBase;
    protected int saldoBancoHoras;

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }

    public br.edu.ifnmg.enums.StatusFuncionario getStatus() {
        return status;
    }

    public Funcionario(){}

    public Funcionario(String nome, LocalDate dataNascimento,
                       List<Dependente> listaDependentes, LocalDate dataRegistro, int diasContratoExperiencia,
                       int setorId, String funcao, BigDecimal salarioBase) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataRegistro = dataRegistro;
        this.diasContratoExperiencia = diasContratoExperiencia;
        this.setorId = setorId;
        this.funcao = funcao;
        this.salarioBase = salarioBase;
        this.saldoBancoHoras = 0;

    }

    public static BigDecimal getSalarioMinimo() {
        return SALARIO_MINIMO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public int getDiasContratoExperiencia() {
        return diasContratoExperiencia;
    }

    public void setDiasContratoExperiencia(int diasContratoExperiencia) {
        this.diasContratoExperiencia = diasContratoExperiencia;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public int getSetorId() {
        return setorId;
    }

    public void setSetorId(int setorId) {
        this.setorId = setorId;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getSaldoBancoHoras() {
        return saldoBancoHoras;
    }

    public void setSaldoBancoHoras(int saldoBancoHoras) {
        this.saldoBancoHoras = saldoBancoHoras;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    // Alterar Status, Criar Rescisão (Tempo de Empresa, Pagamento FGTS, Acerto (Créditos e Débitos)
    public void desligarFuncionario(){
        this.dataDemissao = LocalDate.now();
        this.status = StatusFuncionario.DESLIGADO;
        DireitoTrabalhista novaRescisao = new Rescisao(TipoDireitoTrabalhista.RESCISAO, dataDemissao, id,
                MotivoRescisao.JUSTA_CAUSA, TipoAvisoPrevio.INDENIZADO);
    }

    public int recuperarNumeroMesesTrabalhadosNoAno(){
        LocalDate dataRegistroFuncionario = this.dataRegistro;
        LocalDate dataFinal = LocalDate.now();

        int numeroMesesTrabalhados = dataFinal.getMonthValue() - dataRegistroFuncionario.getMonthValue();

        int numeroDiaRegistroFuncionario;
        LocalDate ultimoDiaDoMesDoRegistroFuncionario;
        int numeroUltimoDiaDoMesDoRegistroFuncionario;
        int parcelaMes;
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.lastDayOfMonth();

        if (dataRegistroFuncionario.getDayOfMonth() != 1){
            numeroDiaRegistroFuncionario = dataRegistroFuncionario.getDayOfMonth();
            ultimoDiaDoMesDoRegistroFuncionario = dataRegistroFuncionario.with(temporalAdjuster);
            numeroUltimoDiaDoMesDoRegistroFuncionario = ultimoDiaDoMesDoRegistroFuncionario.getDayOfMonth();
            parcelaMes = (numeroUltimoDiaDoMesDoRegistroFuncionario - numeroDiaRegistroFuncionario) / 30;
        } else {
            parcelaMes = 1;
        }

        return numeroMesesTrabalhados + parcelaMes;
    }

    /* TODO: REGRAS DE VALIDAÇÃO (REGEX)
    ** Nome: de 5 até 50 caracteres
    ** Datas: Formato DD/MM/AAAA
    ** Documentos Obrigatórios: RG, CPF, PIS. Em caso de filhos < 14 anos, Certidão de Nascimento e CPF deles.
    ** diasContratoExperiência: após o período informado, a rescisão será mais rígida.
    ** salarioBase: maior ou igual ao SALARIO_MINIMO.
    */
    public boolean validarFuncionario(Funcionario funcionario){
        return true;
    }

    public void contratarFuncionario(Funcionario funcionario){
        funcionario.setStatus(StatusFuncionario.ATIVO);
        funcionario.setDataRegistro(LocalDate.now());
    }

}
