<%-- 
   /**
    *
    * @author joaof
   */
--%>

<%@page import="java.beans.JavaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="model.DispositivoBeans"%>
<%@page import ="java.util.ArrayList"%>
<%
    @SuppressWarnings("unchecked") 
    ArrayList<DispositivoBeans> lista = (ArrayList<DispositivoBeans>) request.getAttribute("dispositivos");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Impact Monitor</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <a href="main" class="BotaoPesquisar"><</a> 
        <h1>Dispositivo</h1>
        <table id="tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOME</th>
                </tr>
            </thead>
            <tbody>
                <% if (lista != null) { %>
                <% for (int i = 0; i < lista.size(); i++) {%>
                <tr>
                    <td id="td" ><%=lista.get(i).getId_dispositivo()%></td>
                    <td id="td" ><%=lista.get(i).getNome_dispositivo()%></td>
                </tr>
                <% } %>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
