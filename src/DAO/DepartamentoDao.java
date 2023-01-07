/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Departamento;
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
public class DepartamentoDao {
    
    private final Connection connection;

    public DepartamentoDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }
    
    public void SalvarDepartamento(Departamento departamento) {
        String sql = "Insert into Departamento (NomeDepartamento, percentualAtual) values(?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, departamento.getNomeDepartamento());
            pst.setString(2, departamento.getPercentAtual());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        

    }
    
    public void AtualizarDepartamento(Departamento departamento) {
        String sql = "Update Departamento set CodigoDepartamento=?, NomeDepartamento=?, percentualAtual=? where CodigoDepartamento=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, departamento.getCodigoDepartamento());
            pst.setString(2, departamento.getNomeDepartamento());
            pst.setString(3, departamento.getPercentAtual());
            pst.setInt(4, departamento.getCodigoDepartamento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Método Excluír
    public void Excluir(Departamento departamento) {
        String sql = "Delete from Departamento where CodigoDepartamento=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, departamento.getCodigoDepartamento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados da cidade!!");
        }
    }
    
    public Vector CarregarDepartamentoTabela() {

        Vector DadosDepartamento = new Vector();

        String sql = "SELECT CodigoDepartamento, NomeDepartamento, percentualAtual FROM Departamento";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoDepartamento"));
                dados.add(rs.getString("NomeDepartamento"));
                dados.add(rs.getString("percentualAtual"));
                DadosDepartamento.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosDepartamento;
    }
    
    
}