package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DaoRegistro;
import model.DaoDispositivo;
import model.ImpactoBeans;
import model.DispositivoBeans;

/**
 *
 * @author joaof
 */
@WebServlet(urlPatterns = {"/Controller", "/main", "/delete", "/timeSearch", "/singleTimeSearch", "/idSearch", "/dateSearch", "/singleDateSearch", "/dispositivo", "/deviceSearch"})
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ImpactoBeans impacto = new ImpactoBeans();
    DaoRegistro daoRegistro = new DaoRegistro();
    DaoDispositivo daoDispositivo = new DaoDispositivo();

    public Controller() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/main")) {
            impactos(request, response);
        } else if (action.equals("/delete")) {
            excluirImpacto(request, response);
        } else if (action.equals("/timeSearch")) {
            pesquisaHora(request, response);
        } else if (action.equals("/singleTimeSearch")) {
            pesquisaHoraUnica(request, response);
        } else if (action.equals("/idSearch")) {
            pesquisaId(request, response);
        } else if (action.equals("/dateSearch")) {
            pesquisaData(request, response);
        } else if (action.equals("/singleDateSearch")) {
            pesquisaDataUnica(request, response);
        } else if (action.equals("/dispositivo")) {
            dispositivos(request, response);
        } else if (action.equals("/deviceSearch")) {
            pesquisaDispositivo(request, response);
        } else {
            response.sendRedirect("registros.html");
        }
    }

    protected void impactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ImpactoBeans> lista = daoRegistro.listarImpactos();
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void excluirImpacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_impacto = request.getParameter("id_impacto");
        impacto.setN_impacto(id_impacto);
        daoRegistro.excluirImpacto(impacto);
        response.sendRedirect("main");
    }

    protected void pesquisaHora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inicio = request.getParameter("horarioInicio");
        String fim = request.getParameter("horarioFim");
        ArrayList<ImpactoBeans> lista = daoRegistro.pesquisaHorario(inicio, fim);
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void pesquisaHoraUnica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inicio = request.getParameter("horarioInicio");
        ArrayList<ImpactoBeans> lista = daoRegistro.pesquisaUnicaHorario(inicio);
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void pesquisaId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idImpacto = request.getParameter("idImpacto");
        System.out.println(idImpacto);
        ArrayList<ImpactoBeans> lista = daoRegistro.pesquisaId(idImpacto);
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void pesquisaData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dataInicio = request.getParameter("dataInicio");
        String dataFim = request.getParameter("dataFim");
        ArrayList<ImpactoBeans> lista = daoRegistro.pesquisaData(dataInicio, dataFim);
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void pesquisaDataUnica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dataInicio = request.getParameter("dataInicio");
        ArrayList<ImpactoBeans> lista = daoRegistro.pesquisaDataUnica(dataInicio);
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void pesquisaDispositivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dispositivo = request.getParameter("device");
        ArrayList<ImpactoBeans> lista = daoDispositivo.pesquisaDipositivo(dispositivo);
        request.setAttribute("impactos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("registros.jsp");
        rd.forward(request, response);
    }

    protected void dispositivos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DispositivoBeans> lista = daoDispositivo.listarDispositivo();
        request.setAttribute("dispositivos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("dispositivo.jsp");
        rd.forward(request, response);
    }

}
