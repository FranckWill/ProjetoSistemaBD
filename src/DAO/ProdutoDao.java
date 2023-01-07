/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Produto;
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
public class ProdutoDao {
    
    private final Connection connection;

    public ProdutoDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }
    
    public void SalvarProduto(Produto produto) {
        String sql = "Insert into Produto (NomeProduto, UnidadeMedida, PrecoProduto, QuantidadeEstocada) values(?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, produto.getNomeProduto());
            pst.setString(2, produto.getUnidadeMedida());
            pst.setDouble(3, produto.getPrecoProduto());
            pst.setInt(4, produto.getQuantEstoq());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    // método para Atualizar
    public void AtualizarProduto(Produto produto) {
        String sql = "Update Produto set CodigoProduto=?, NomeProduto=?, UnidadeMedida=?, PrecoProduto=?, QuantidadeEstocada=? where CodigoProduto=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, produto.getCodigoProduto());
            pst.setString(2, produto.getNomeProduto());
            pst.setString(3, produto.getUnidadeMedida());
            pst.setDouble(4, produto.getPrecoProduto());
            pst.setInt(5, produto.getQuantEstoq());
            pst.setInt(6, produto.getCodigoProduto());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Método Excluír
    public void Excluir(Produto produto) {
        String sql = "Delete from Produto where CodigoProduto=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, produto.getCodigoProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados da cidade!!");
        }
    }
    
    public Vector CarregarProdutoTabela() {

        Vector DadosProduto = new Vector();

        String sql = "SELECT CodigoProduto, NomeProduto, UnidadeMedida, PrecoProduto, QuantidadeEstocada FROM Produto";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoProduto"));
                dados.add(rs.getString("NomeProduto"));
                dados.add(rs.getString("UnidadeMedida"));
                dados.add(rs.getDouble("PrecoProduto"));
                dados.add(rs.getInt("QuantidadeEstocada"));
                DadosProduto.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosProduto;
    }
    
    
}