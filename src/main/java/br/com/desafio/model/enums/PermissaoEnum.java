package br.com.desafio.model.enums;

public enum PermissaoEnum {

    PERMITIDO("SIM", "Permitido"),
    NAO_PERMITIDO("NÃO", "Não Permitido");

    private final String valor;
    private final String descricao;

    PermissaoEnum(String valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
}
