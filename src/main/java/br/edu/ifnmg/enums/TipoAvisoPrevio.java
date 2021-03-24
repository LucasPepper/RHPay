package br.edu.ifnmg.enums;

// Indenizado: Demissão sem Justa Causa (Funcionário desligado imediatamente) - 40% FGTS + Férias + Valor proporcional 13º
// Trabalhado: Continua-se trabalhando após o Aviso Prévio, em um período de 30 a 90 dias.
// O Aviso Prévio Proporcional é de acordo com o tempo trabalhado na empresa.
// Menos de 1 ano = 30 dias. A cada ano adicional, soma-se 3 dias.
// https://www.pontotel.com.br/aviso-previo-indenizado/#:~:text=O%20aviso%20pr%C3%A9vio%20indenizado%2C%20ocorre%20na%20demiss%C3%A3o%20sem%20justa%20causa,e%20m%C3%A1ximo%20de%2090%20dias.
public enum TipoAvisoPrevio {
    TRABALHADO,
    INDENIZADO
}
