/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author 06940565108
 */
public class RegistroVendas {
    public int CodigoRegistroVendas;
    public double StatusComissao;
    public double TotalVenda;
    public String DataVenda;
    public double PercentComissao;
    public Departamento CodigoDepartamento;
    public Vendedor CodigoVendedor;

    public int getCodigoRegistroVendas() {
        return CodigoRegistroVendas;
    }

    public void setCodigoRegistroVendas(int CodigoRegistroVendas) {
        this.CodigoRegistroVendas = CodigoRegistroVendas;
    }

    public double getStatusComissao() {
        return StatusComissao;
    }

    public void setStatusComissao(double StatusComissao) {
        this.StatusComissao = StatusComissao;
    }

    public double getTotalVenda() {
        return TotalVenda;
    }

    public void setTotalVenda(double TotalVenda) {
        this.TotalVenda = TotalVenda;
    }

    public String getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(String DataVenda) {
        this.DataVenda = DataVenda;
    }

    public double getPercentComissao() {
        return PercentComissao;
    }

    public void setPercentComissao(double PercentComissao) {
        this.PercentComissao = PercentComissao;
    }

    public Departamento getCodigoDepartamento() {
        return CodigoDepartamento;
    }

    public void setCodigoDepartamento(Departamento CodigoDepartamento) {
        this.CodigoDepartamento = CodigoDepartamento;
    }

    public Vendedor getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(Vendedor CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }
    
}
