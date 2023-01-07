/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author 06940565108
 */
public class Departamento {
    public int codigoDepartamento;
    public String nomeDepartamento;
    public String percentAtual;

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getPercentAtual() {
        return percentAtual;
    }

    public void setPercentAtual(String percentAtual) {
        this.percentAtual = percentAtual;
    }

    @Override
    public String toString() {
        return nomeDepartamento;
    }
    
    
}
