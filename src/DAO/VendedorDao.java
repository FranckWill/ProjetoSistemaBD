/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Vendedor;
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
 * @author 04795661197
 */

public class VendedorDao {

    private final Connection connection;

    public VendedorDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }

    // método para Salvar
    public void SalvarVendedor(Vendedor vendedor) {
        String sql = "Insert into Vendedor (NomeVendedor, StatusVendedor, DataAdmissao, RG, Departamento_CodigoDepartamento) values(?,?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, vendedor.getNomeVendedor());
            pst.setString(2, vendedor.getStatusVend());
            pst.setString(3, vendedor.getDataAdmissao());
            pst.setString(4, vendedor.getRg());
            pst.setInt(5, vendedor.getDepart().getCodigoDepartamento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     // Método Excluír
    public void Excluir(Vendedor vendedor) {
        String sql = "Delete from Vendedor where CodigoVendedor=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, vendedor.getCodVendedor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados do Vendedor!!");
        }
    }

    // método para Atualizar
    public void AtualizarVendedor(Vendedor vendedor) {
        String sql = "Update Vendedor set CodigoVendedor=?, NomeVendedor=?, StatusVendedor=?, DataAdmissao=?, RG=?, Departamento_CodigoDepartamento=? where CodigoVendedor=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, vendedor.getCodVendedor());
            pst.setString(2, vendedor.getNomeVendedor());
            pst.setString(3, vendedor.getStatusVend());
            pst.setString(4, vendedor.getDataAdmissao());
            pst.setString(5, vendedor.getRg());
            pst.setInt(6, vendedor.getDepart().getCodigoDepartamento());
            pst.setInt(7, vendedor.getCodVendedor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Método Carregar Departamento
    public Vector<Departamento> CarregarDepartamento() {
        Vector<Departamento> dados = new Vector<Departamento>();
        String sql = "Select CodigoDepartamento, NomeDepartamento from Departamento";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Departamento depart = new Departamento();
                depart.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                depart.setNomeDepartamento(rs.getString("NomeDepartamento"));
                dados.add(depart);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
    

    // Método Carregar Tabela
    public Vector CarregarVendedorTabela() {

        Vector DadosVendedor = new Vector();

        String sql = "select CodigoVendedor, NomeVendedor, StatusVendedor, DataAdmissao, RG, NomeDepartamento from\n"
                + "Vendedor inner JOIN Departamento on Vendedor.Departamento_CodigoDepartamento=Departamento.CodigoDepartamento";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoVendedor"));
                dados.add(rs.getString("NomeVendedor"));
                dados.add(rs.getString("StatusVendedor"));
                dados.add(rs.getString("DataAdmissao"));
                dados.add(rs.getString("RG"));
                dados.add(rs.getString("NomeDepartamento"));
                DadosVendedor.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosVendedor;
    }

    // Método para pesquisar o departamento
    public Vendedor PesquisarDepartamento(int id) {
        Vendedor vendedor = null;
        Departamento depart = null;
        
      
        String Sql = "select CodigoVendedor, Departamento.CodigoDepartamento, Departamento.NomeDepartamento, NomeVendedor, StatusVendedor, DataAdmissao, RG from Vendedor\n" +
"                inner join Departamento ON Vendedor.Departamento_CodigoDepartamento=Departamento.CodigoDepartamento where CodigoVendedor=" + id;

        try {
            PreparedStatement pst = connection.prepareStatement(Sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                depart = new Departamento();
                vendedor = new Vendedor();

                depart.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                depart.setNomeDepartamento(rs.getString("NomeDepartamento"));
                

                vendedor.setCodVendedor(rs.getInt("CodigoVendedor"));
                vendedor.setNomeVendedor(rs.getString("NomeVendedor"));
                vendedor.setStatusVend(rs.getString("StatusVendedor"));
                vendedor.setDataAdmissao(rs.getString("DataAdmissao"));
                vendedor.setRg(rs.getString("RG"));

                vendedor.setDepart(depart);

            }

            // return  true;
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendedor;
    }
}
