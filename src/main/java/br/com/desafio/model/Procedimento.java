package br.com.desafio.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedimentos")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Procedimento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Procedimento() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
