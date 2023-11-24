<%@ page import="br.com.desafio.model.Solicitacao" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.desafio.dao.SolicitacaoDAO" %>
<%@ page import="br.com.desafio.util.ConnectionFactory" %>
<%@ page import="javax.persistence.EntityManager" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Zitrus - Desafio Java Servlet</title>
    <link rel="stylesheet" href="css/bootstrap.css"></link>
</head>
<body>
<jsp:include page="header.jsp"/>

<h3>Nova Solicitação</h3>


<div class="row">
    <div class="col-md-4">
        <form data-bitwarden-watching="1" action="solicitacao" method="POST">

            <div class="form-group">
                <label class="col-form-label mt-4" for="nome">Nome:</label>
                <input type="text" class="form-control" placeholder="Nome" name="nome" id="nome">

            </div>

            <div class="form-group">
                <label class="col-form-label mt-4" for="idade">Idade:</label>
                <input type="text" class="form-control" placeholder="Idade" name="idade" id="idade">

            </div>

            <div class="form-group">
                <label class="col-form-label mt-4" for="sexo">Sexo:</label>
                <input type="text" class="form-control" placeholder="Sexo" name="sexo" id="sexo">

            </div>

            <div class="form-group">
                <label class="col-form-label mt-4" for="procedimento">Procedimento:</label>
                <input type="text" class="form-control" placeholder="Procedimento" name="procedimento" id="procedimento">

            </div>


            <button type="submit" class="btn btn-success" id="cadastrarSolicitacao">Solicitar</button>

          </form>


    </div>
</div>

<table class="mt-3 table table-hover caption-top">
    <caption class="h4">Solicitações</caption>
    <thead class="table-light">
    <th>Procedimento</th>
    <th>Nome</th>
    <th>Idade</th>
    <th>Sexo</th>
    <th>Status</th>
    </thead>
    <tbody>
    <%
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(entityManager);
        List<Solicitacao> solicitacoes = solicitacaoDAO.buscarTodos();

        for (Solicitacao solicitacao : solicitacoes){
    %>
    <tr>
    <td><%= solicitacao.getNome() %></td>
    <td><%= solicitacao.getIdade() %></td>
    <td><%= solicitacao.getSexo().getDescricao() %></td>
    <td><%= solicitacao.getProcedimento().getNome() %></td>
    <td><%= solicitacao.getPermissao().getDescricao() %></td>
    </tr>
    <%
        }
    %>


    </tbody>
</table>


</body>
</html>
