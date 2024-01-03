package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joaof
 */
public class DaoRegistro {

    private final String url = "jdbc:mysql://localhost:3306/esp8266?user=root&password=060705";
    private final String driver = "com.mysql.cj.jdbc.Driver";

    private Connection conexaoBD() {
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }

    public ArrayList<ImpactoBeans> listarImpactos() {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "select * from registro";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String n_impacto = rs.getString(1);
                String id_impacto = rs.getString(2);
                String msg_impacto = rs.getString(3);
                String hora_impacto = rs.getString(4);
                String data_impacto = rs.getString(5);
                impactos.add(new ImpactoBeans(n_impacto, id_impacto, msg_impacto, hora_impacto, data_impacto));
            }
            conexao.close();
            return impactos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void excluirImpacto(ImpactoBeans impacto) {
        String delete = "delete from registro WHERE id_impacto = ?";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pst = conexao.prepareStatement(delete);
            pst.setString(1, impacto.getN_impacto());
            pst.executeUpdate();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ImpactoBeans> pesquisaHorario(String horaInicio, String horaFim) {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "SELECT * FROM registro where hora_impacto >= '" + horaInicio + "' AND hora_impacto <= '" + horaFim + "'";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String n_impacto = rs.getString(1);
                String id_impacto = rs.getString(2);
                String msg_impacto = rs.getString(3);
                String hora_impacto = rs.getString(4);
                String data_impacto = rs.getString(5);
                impactos.add(new ImpactoBeans(n_impacto, id_impacto, msg_impacto, hora_impacto, data_impacto));
            }
            conexao.close();
            return impactos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<ImpactoBeans> pesquisaUnicaHorario(String horaInicio) {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "SELECT * FROM registro WHERE hora_impacto = '" + horaInicio + "'";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String n_impacto = rs.getString(1);
                String id_impacto = rs.getString(2);
                String msg_impacto = rs.getString(3);
                String hora_impacto = rs.getString(4);
                String data_impacto = rs.getString(5);
                impactos.add(new ImpactoBeans(n_impacto, id_impacto, msg_impacto, hora_impacto, data_impacto));
            }
            conexao.close();
            return impactos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<ImpactoBeans> pesquisaId(String id) {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "SELECT * FROM registro where id_impacto like '" + id + "'";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String n_impacto = rs.getString(1);
                String id_impacto = rs.getString(2);
                String msg_impacto = rs.getString(3);
                String hora_impacto = rs.getString(4);
                String data_impacto = rs.getString(5);
                impactos.add(new ImpactoBeans(n_impacto, id_impacto, msg_impacto, hora_impacto, data_impacto));
            }
            conexao.close();
            return impactos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<ImpactoBeans> pesquisaData(String dataInicio, String dataFim) {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "SELECT * FROM registro where data_impacto >= '" + dataInicio + "' AND data_impacto <= '" + dataFim + "'";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String n_impacto = rs.getString(1);
                String id_impacto = rs.getString(2);
                String msg_impacto = rs.getString(3);
                String hora_impacto = rs.getString(4);
                String data_impacto = rs.getString(5);
                impactos.add(new ImpactoBeans(n_impacto, id_impacto, msg_impacto, hora_impacto, data_impacto));
            }
            conexao.close();
            return impactos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<ImpactoBeans> pesquisaDataUnica(String dataInicio) {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "SELECT * FROM registro where data_impacto = '" + dataInicio + "'";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String n_impacto = rs.getString(1);
                String id_impacto = rs.getString(2);
                String msg_impacto = rs.getString(3);
                String hora_impacto = rs.getString(4);
                String data_impacto = rs.getString(5);
                impactos.add(new ImpactoBeans(n_impacto, id_impacto, msg_impacto, hora_impacto, data_impacto));
            }
            conexao.close();
            return impactos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
