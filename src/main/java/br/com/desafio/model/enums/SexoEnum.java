package br.com.desafio.model.enums;

public enum SexoEnum {
    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private final String valor;
    private final String descricao;

    SexoEnum(String valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
