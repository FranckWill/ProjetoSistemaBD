/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import java.sql.Connection;
import Controle.RegistroVendas;
import Controle.Departamento;
import Controle.Vendedor;
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
public class RegistroVendasDao {
    
    private final Connection connection;

    public RegistroVendasDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }

    // Método Salvar
    public void SalvarRegistroVendas(RegistroVendas registroVendas) {
        String sql = "Insert into RegistroVendas (StatusComissao, TotalVenda, DataVenda, PercentComissao, Vendedor_CodigoVendedor, Departamento_CodigoDepartamento ) values(?,?,?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setDouble(1, registroVendas.getStatusComissao());
            pst.setDouble(2, registroVendas.getTotalVenda());
            pst.setString(3, registroVendas.getDataVenda());
            pst.setDouble(4, registroVendas.getPercentComissao());
            pst.setInt(5, registroVendas.getCodigoVendedor().getCodVendedor());
            pst.setInt(6, registroVendas.getCodigoDepartamento().getCodigoDepartamento());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // método para Atualizar
    public void AtualizarRegistroVendas(RegistroVendas registroVendas) {
        String sql = "Update RegistroVendas set CodigoRegistroVendas=?, StatusComissao=?, TotalVenda=?, DataVenda=?, PercentComissao=?, Vendedor_CodigoVendedor=?, Departamento_CodigoDepartamento=? where CodigoRegistroVendas=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, registroVendas.getCodigoRegistroVendas());
            pst.setDouble(2, registroVendas.getStatusComissao());
            pst.setDouble(3, registroVendas.getTotalVenda());
            pst.setString(4, registroVendas.getDataVenda());
            pst.setDouble(5, registroVendas.getPercentComissao());
            pst.setInt(6, registroVendas.getCodigoVendedor().getCodVendedor());
            pst.setInt(7, registroVendas.getCodigoDepartamento().getCodigoDepartamento());
            pst.setInt(8, registroVendas.getCodigoRegistroVendas());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Método Excluír
    public void Excluir(RegistroVendas registro) {
        String sql = "Delete from RegistroVendas where CodigoRegistroVendas=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, registro.getCodigoRegistroVendas());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados do Registro de Vendas!!");
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
                Departamento departamento = new Departamento();
                departamento.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));
                dados.add(departamento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
    
    // Método Carregar Vendedor
    public Vector<Vendedor> CarregarVendedor() {
        Vector<Vendedor> dados = new Vector<Vendedor>();
        String sql = "Select CodigoVendedor, NomeVendedor from Vendedor";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCodVendedor(rs.getInt("CodigoVendedor"));
                vendedor.setNomeVendedor(rs.getString("NomeVendedor"));
                dados.add(vendedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
    
    // Método Carregar Tabela
    public Vector CarregarRegistroVendasTabela() {

        Vector DadosRegistroVendas = new Vector();

        String sql = "select CodigoRegistroVendas, StatusComissao, TotalVenda, DataVenda, PercentComissao, NomeVendedor, NomeDepartamento from\n"
                + "RegistroVendas inner JOIN Vendedor on RegistroVendas.Vendedor_CodigoVendedor=Vendedor.CodigoVendedor\n"
                + "Inner JOIN Departamento on RegistroVendas.Departamento_CodigoDepartamento=Departamento.CodigoDepartamento";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoRegistroVendas"));
                dados.add(rs.getDouble("StatusComissao"));
                dados.add(rs.getDouble("TotalVenda"));
                dados.add(rs.getString("DataVenda"));
                dados.add(rs.getDouble("PercentComissao"));
                dados.add(rs.getString("NomeVendedor"));
                dados.add(rs.getString("NomeDepartamento"));
                DadosRegistroVendas.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosRegistroVendas;
    }
    
    // Método para pesquisar registro
    public RegistroVendas PesquisarRegistro(int id) {
        RegistroVendas registrovendas = null;
        Vendedor vendedor = null;
        Departamento departamento = null;
        
      
        String Sql = "select CodigoRegistroVendas, Vendedor.CodigoVendedor, Departamento.CodigoDepartamento, NomeDepartamento, NomeVendedor,  StatusComissao, TotalVenda, DataVenda, PercentComissao from RegistroVendas\n" +
"                inner join Vendedor ON RegistroVendas.Vendedor_CodigoVendedor=Vendedor.CodigoVendedor INNER JOIN Departamento\n" +
"                on RegistroVendas.Departamento_CodigoDepartamento=Departamento.CodigoDepartamento where CodigoRegistroVendas=" + id;

        try {
            PreparedStatement pst = connection.prepareStatement(Sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                vendedor = new Vendedor();
                registrovendas = new RegistroVendas();
                departamento = new Departamento();

                vendedor.setCodVendedor(rs.getInt("CodigoVendedor"));
                vendedor.setNomeVendedor(rs.getString("NomeVendedor"));
                
                departamento.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));

                registrovendas.setCodigoRegistroVendas(rs.getInt("CodigoRegistroVendas"));
                registrovendas.setStatusComissao(rs.getDouble("StatusComissao"));
                registrovendas.setTotalVenda(rs.getDouble("TotalVenda"));
                registrovendas.setDataVenda(rs.getString("DataVenda"));
                registrovendas.setPercentComissao(rs.getDouble("PercentComissao"));

                registrovendas.setCodigoVendedor(vendedor);
                registrovendas.setCodigoDepartamento(departamento);

            }

            // return  true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistroVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registrovendas;
    }
    
}
