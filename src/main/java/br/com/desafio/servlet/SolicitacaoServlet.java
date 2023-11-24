package br.com.desafio.servlet;
import br.com.desafio.dao.ProcedimentoDAO;
import br.com.desafio.dao.SolicitacaoDAO;
import br.com.desafio.model.Procedimento;
import br.com.desafio.model.Solicitacao;
import br.com.desafio.model.enums.SexoEnum;
import br.com.desafio.util.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import br.com.desafio.model.enums.PermissaoEnum;
import jakarta.servlet.RequestDispatcher;
import javax.persistence.EntityManager;


@WebServlet("/solicitacao")
public class SolicitacaoServlet extends HttpServlet {

    EntityManager entityManager = ConnectionFactory.getEntityManager();
    SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(entityManager);
    ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO(entityManager);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        SexoEnum sexo = SexoEnum.fromValue(request.getParameter("sexo"));
        Procedimento procedimento = procedimentoDAO.buscarPorId(Long.parseLong(request.getParameter("procedimento")));

        Solicitacao solicitacao = new Solicitacao(procedimento, nome, idade, sexo, PermissaoEnum.PERMITIDO);
        entityManager.getTransaction().begin();
        solicitacaoDAO.cadastrar(solicitacao);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    private void PopulaHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Solicitacao> solicitacoes = solicitacaoDAO.buscarTodos();
        request.setAttribute("procedimentos", procedimentoDAO.buscarTodos());
        request.setAttribute("sexos", SexoEnum.values());
        request.setAttribute("solicitacoes", solicitacoes);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

}
