package br.com.desafio.servlet;
import br.com.desafio.dao.ProcedimentoDAO;
import br.com.desafio.dao.RegraDAO;
import br.com.desafio.dao.SolicitacaoDAO;
import br.com.desafio.model.Procedimento;
import br.com.desafio.model.Solicitacao;
import br.com.desafio.model.enums.SexoEnum;
import br.com.desafio.util.ConnectionFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import br.com.desafio.model.enums.PermissaoEnum;
import javax.persistence.EntityManager;


@WebServlet("/solicitacao")
public class SolicitacaoServlet extends HttpServlet {

    EntityManager entityManager = ConnectionFactory.getEntityManager();
    SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(entityManager);
    ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO(entityManager);
    RegraDAO regraDAO = new RegraDAO(entityManager);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        Procedimento procedimento = procedimentoDAO.buscarPorId(Long.parseLong(request.getParameter("procedimento")));
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        SexoEnum sexo = SexoEnum.fromValue(request.getParameter("sexo"));

        Solicitacao solicitacao = new Solicitacao(procedimento, nome, idade, sexo, PermissaoEnum.NAO_PERMITIDO);
        boolean autorizacaoDaSolicitacao = regraDAO.validaSolicitacao(solicitacao);

        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
            solicitacao.setId(Long.parseLong(request.getParameter("id")));
            solicitacaoDAO.alterarSolicitacao(solicitacao, autorizacaoDaSolicitacao);
        } else {
            solicitacaoDAO.criaSolicitacao(solicitacao, autorizacaoDaSolicitacao);
        }

        populaIndex(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Procedimento inválido. Solicitação negada.");
        }
    }

    private void populaIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("procedimentos", procedimentoDAO.buscarTodos());
        request.setAttribute("sexos", SexoEnum.values());
        request.setAttribute("solicitacoes", solicitacaoDAO.buscarTodos());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
