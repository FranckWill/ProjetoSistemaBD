/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 06940565108
 */
public class CadastroDAO {
    private final Connection connection;

    public CadastroDAO() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }
    
    public void SalvarCadastro(Cadastro cadastro) {
        String sql = "Insert into Cadastro(Usuario, Senha) values(?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, cadastro.getUser());
            pst.setString(2, cadastro.getPass());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
}
