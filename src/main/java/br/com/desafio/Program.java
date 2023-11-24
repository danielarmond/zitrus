package br.com.desafio;

import br.com.desafio.dao.ProcedimentoDAO;
import br.com.desafio.dao.SolicitacaoDAO;
import br.com.desafio.model.Solicitacao;
import br.com.desafio.util.ConnectionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        EntityManager entityManager = ConnectionFactory.getEntityManager();
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(entityManager);

        List<Solicitacao> todos = solicitacaoDAO.buscarTodos();
        todos.forEach(p -> System.out.println(p.getProcedimento().getNome()));
    }
}
