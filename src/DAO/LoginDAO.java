/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 06940565108
 */
public class LoginDAO {
    private final Connection connection;

    public LoginDAO() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }
    
    public Vector CarregarCadastroTabela() {

        Vector Cadastro = new Vector();

        String sql = "SELECT id, Usuario, Senha FROM Cadastro";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("id"));
                dados.add(rs.getString("Usuario"));
                dados.add(rs.getString("Senha"));
                Cadastro.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Cadastro;
    }
    
    
    
}
