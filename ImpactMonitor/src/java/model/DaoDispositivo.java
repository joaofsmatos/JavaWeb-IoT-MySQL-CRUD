/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joaof
 */
public class DaoDispositivo {
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

    public ArrayList<DispositivoBeans> listarDispositivo() {
        ArrayList<DispositivoBeans> dispositivo = new ArrayList<>();
        String read = "select * from dispositivo";
        try {
            Connection conexao = conexaoBD();
            PreparedStatement pt = conexao.prepareStatement(read);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String id_dispositivo = rs.getString(1);
                String nome_dispositivo = rs.getString(2);
                dispositivo.add(new DispositivoBeans(id_dispositivo, nome_dispositivo));
            }
            conexao.close();
            return dispositivo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<ImpactoBeans> pesquisaDipositivo(String nomeDispositivo) {
        ArrayList<ImpactoBeans> impactos = new ArrayList<>();
        String read = "SELECT * FROM registro WHERE FK_id_dispositivo LIKE '" + nomeDispositivo + "'";
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
