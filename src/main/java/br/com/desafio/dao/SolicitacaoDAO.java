package br.com.desafio.dao;
import br.com.desafio.model.Solicitacao;
import javax.persistence.EntityManager;
import java.util.List;


public class SolicitacaoDAO {

    private EntityManager entityManager;

    public SolicitacaoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar (Solicitacao pedido) {
        this.entityManager.persist(pedido);

    }
    public Solicitacao buscarPorId(Long id) {
        return entityManager.find(Solicitacao.class, id);

    }
    public List<Solicitacao> buscarTodos(){
        String jpql = "SELECT p FROM Solicitacao p";
        return entityManager.createQuery(jpql, Solicitacao.class).getResultList();

    }
    public List<Solicitacao> buscarPorNome(String nome){
        String jpql = "SELECT p FROM Solicitacao p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql, Solicitacao.class).setParameter("nome", nome).getResultList();

    }
}
