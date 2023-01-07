/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Setor;
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
public class SetorDao {
    
    private final Connection connection;

    public SetorDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }
    
    // método para Salvar
    public void SalvarSetor(Setor setor) {
        String sql = "Insert into Setor (NomeSetor, Departamento_CodigoDepartamento) values(?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, setor.getNomeSetor());
            pst.setInt(2, setor.getCodigoDepartamento().getCodigoDepartamento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(SetorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }
    
    // método para Atualizar
    public void AtualizarSetor(Setor setor) {
        String sql = "Update Setor set CodigoSetor=?, NomeSetor=?, Departamento_CodigoDepartamento=? where CodigoSetor=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, setor.getCodigoSetor());
            pst.setString(2, setor.getNomeSetor());
            pst.setInt(3, setor.getCodigoDepartamento().getCodigoDepartamento());
            pst.setInt(4, setor.getCodigoSetor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(SetorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void Excluir(Setor setor) {
        String sql = "Delete from Setor where CodigoSetor=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, setor.getCodigoSetor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(SetorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados da cidade!!");
        }
    }
    
    // Método Carregar Cidade
    public Vector<Departamento> CarregarDepartamento() {
        Vector<Departamento> dados = new Vector<Departamento>();
        String sql = "Select CodigoDepartamento , NomeDepartamento from Departamento";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));
                dados.add(departamento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SetorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
    
    // Método Carregar Tabela
    public Vector CarregarSetorTabela() {

        Vector DadosSetor = new Vector();

        String sql = "select CodigoSetor, NomeSetor, NomeDepartamento from\n"
                + "Setor inner JOIN Departamento on Setor.Departamento_CodigoDepartamento=Departamento.CodigoDepartamento";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoSetor"));
                dados.add(rs.getString("NomeSetor"));
                dados.add(rs.getString("NomeDepartamento"));
                DadosSetor.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SetorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosSetor;
    }
    
    // Método para pesquisar  a cidade e curso
    public Setor PesquisarDepartamento(int id) {        
        Setor setor = null;
        Departamento departamento = null;
        
      
        String Sql = "select CodigoSetor, Departamento.CodigoDepartamento, NomeDepartamento,  NomeSetor from Setor\n" +
"                inner join Departamento ON Setor.Departamento_CodigoDepartamento=Departamento.CodigoDepartamento where CodigoSetor=" + id;

        try {
            PreparedStatement pst = connection.prepareStatement(Sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                departamento = new Departamento();
                setor = new Setor();

                departamento.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));
                
                setor.setCodigoSetor(rs.getInt("CodigoSetor"));
                setor.setNomeSetor(rs.getString("NomeSetor"));

                setor.setCodigoDepartamento(departamento);

            }

            // return  true;
        } catch (SQLException ex) {
            Logger.getLogger(SetorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return setor;
    }
    
   
}