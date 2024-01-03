<%-- 
   /**
    *
    * @author joaof
   */
--%>

<%@page import="java.beans.JavaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="model.ImpactoBeans"%>
<%@page import ="java.util.ArrayList"%>
<%
    @SuppressWarnings(
            
    
    "unchecked")
    ArrayList<ImpactoBeans> lista = (ArrayList<ImpactoBeans>) request.getAttribute("impactos");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Impact Monitor</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <h1>Registros</h1>
        <form action="search" method="GET" onsubmit="return validateForm()">
            <div class="centered">
                <input id="idImpacto" type="text" name="idImpacto" placeholder="N°">
                <input id="dispositivo" type="text" name="device" placeholder="Dispositivo">
                <input id="horarioInicio" type="time" name="horarioInicio">
                <input id="horarioFim" type="time" name="horarioFim">
                <input id="dataInicio" type="date" name="dataInicio">
                <input id="dataFim" type="date" name="dataFim">
                <button type="submit" class="BotaoPesquisar">🔎</button>
            </div>
        </form>

        <table id="tabela">
            <thead>
                <tr>
                    <th>N°</th>
                    <th> <a href="dispositivo">Dispositivo</a></th>
                    <th>Ocorrência</th>
                    <th>Horário</th>
                    <th>Data</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <% if (lista != null) { %>
                <% for (int i = 0; i < lista.size(); i++) {%>
                <tr>
                    <td id="td" ><%=lista.get(i).getN_impacto()%></td>
                    <td id="td" ><%=lista.get(i).getId_impacto()%></td>
                    <td id="ocorrencia" ><%=lista.get(i).getMsg_impacto()%></td>
                    <td id="td" ><%=lista.get(i).getHora_impacto()%></td>
                    <td id="td" ><%=lista.get(i).getData_impacto()%></td>
                    <td id="td" ><a href="javascript:void(0);" onclick="confirmarExclusao(<%=lista.get(i).getN_impacto()%>)" class="Botao2">Excluir</a></td>
                </tr>
                <% } %>
                <% }%>
            </tbody>
        </table>
    </body>
    <script>
        function confirmarExclusao(id) {
            if (confirm("Tem certeza que deseja excluir o registro?")) {
                window.location.href = "delete?id_impacto=" + id;
            }
        }

        function validateForm() {
            var horarioInicio = document.getElementById("horarioInicio").value;
            var horarioFim = document.getElementById("horarioFim").value;
            var idImpacto = document.getElementById("idImpacto").value;
            var dataInicio = document.getElementById("dataInicio").value;
            var dataFim = document.getElementById("dataFim").value;
            var device = document.getElementById("dispositivo").value;

            if (horarioInicio !== "" && horarioFim !== "") {
                document.querySelector("form").action = "timeSearch";
            } else if (dataInicio !== "" && dataFim !== "") {
                document.querySelector("form").action = "dateSearch";
            } else if (horarioInicio !== "") {
                document.querySelector("form").action = "singleTimeSearch";
            } else if (idImpacto !== "") {
                document.querySelector("form").action = "idSearch";
            } else if (dataInicio !== "") {
                document.querySelector("form").action = "singleDateSearch";
            } else if (device !== "") {
                document.querySelector("form").action = "deviceSearch";
            } else {
                document.querySelector("form").action = "main";
            }

            return true;
        }


        setInterval(function () {
            location.reload();
        }, 5000);
    </script>
</html>
