package br.com.desafio.model;
import javax.persistence.*;
import br.com.desafio.model.enums.PermissaoEnum;
import br.com.desafio.model.enums.SexoEnum;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Procedimento procedimento;
    private String nome;
    private int idade;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
    @Enumerated(EnumType.STRING)
    private PermissaoEnum permissao;

    public Solicitacao(Long id, Procedimento procedimento, String nome, int idade, SexoEnum sexo, PermissaoEnum permissao) {
        this.id = id;
        this.procedimento = procedimento;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.permissao = permissao;
    }

    public Solicitacao(Procedimento procedimento, String nome, int idade, SexoEnum sexo, PermissaoEnum permissao) {
        this.procedimento = procedimento;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.permissao = permissao;
    }

    public Solicitacao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public PermissaoEnum getPermissao() {
        return permissao;
    }

    public void setAutorizado(PermissaoEnum permissao) {
        this.permissao = permissao;
    }
}
