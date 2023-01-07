/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

import Controle.Departamento;
import DAO.DepartamentoDao;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 04795661197
 */
public class FormDepartamento extends javax.swing.JFrame {

    /**
     * Creates new form FormDepartamento
     */
    public FormDepartamento() {
        initComponents();
        CarregarTabela();
        bloquear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPercentual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDepartamento = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Percentual Vendas");

        tbDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Percentual Vendas"
            }
        ));
        tbDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDepartamentoMouseClicked(evt);
            }
        });
        tbDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDepartamentoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDepartamento);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addGap(50, 50, 50)
                        .addComponent(btExcluir)
                        .addGap(57, 57, 57)
                        .addComponent(btEditar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSair)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir)
                    .addComponent(btEditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if (txtCod.getText().equals("")) {
            int i = JOptionPane.showConfirmDialog(null, "Deseja Salvar os Dados", "Cadastro de Departamento", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_NO_OPTION) {
                SalvarDepartamento();
            }

        } else {
            int i = JOptionPane.showConfirmDialog(null, "Deseja Atualizar os Dados", "Cadastro de Departamento", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_NO_OPTION) {
                AtualizarDepartamento();
            }         


    }                                        
      CarregarTabela();
      bloquear();
    }//GEN-LAST:event_btSalvarActionPerformed
    
    
    
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(null, "Deseja Excluir os Dados", "Cadastro de Departamento", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_NO_OPTION) {
                ExcluirDepartamento();
                CarregarTabela();
            }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
      //  System.exit(0);
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tbDepartamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDepartamentoKeyPressed
           preencherInformacao ();

// TODO add your handling code here:
    }//GEN-LAST:event_tbDepartamentoKeyPressed

    private void tbDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDepartamentoMouseClicked
        preencherInformacao ();

// TODO add your handling code here:
    }//GEN-LAST:event_tbDepartamentoMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
    desbloquear();
    txtCod.setText("");






        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        desbloquear();



        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        bloquear();



        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDepartamento().setVisible(true);
            }
        });
    }
    
    //Método salvar 

    public boolean SalvarDepartamento() {

        Departamento departamento = new Departamento();
        departamento.setNomeDepartamento(txtNome.getText());
        departamento.setPercentAtual(txtPercentual.getText());
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamentoDao.SalvarDepartamento(departamento);

        return true;

    }
    
    // Método Atualizar 
    public boolean AtualizarDepartamento() {

        Departamento departamento = new Departamento();

        departamento.setCodigoDepartamento(Integer.parseInt(txtCod.getText()));
        departamento.setNomeDepartamento(txtNome.getText());
        departamento.setPercentAtual(txtPercentual.getText());
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamentoDao.AtualizarDepartamento(departamento);

        return true;

    }
    
    // Método de excluir os dados de acordo com código selecionado

    private boolean ExcluirDepartamento() {
        // Classe que contém os métodos get e set
        Departamento departamento = new Departamento();
        departamento.setCodigoDepartamento(Integer.parseInt(txtCod.getText()));
        // Classe que contém o método de exclusão 
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamentoDao.Excluir(departamento);

        return true;

    }
    
    // método Carregar Tabela
    public void CarregarTabela() {

        Vector cabecalho;
        cabecalho = new Vector();
        cabecalho.add("Código");
        cabecalho.add("Nome Departamento");
        cabecalho.add("Percentual Atual");

        DepartamentoDao departamentoDao = new DepartamentoDao();
        tbDepartamento.setModel(new DefaultTableModel(departamentoDao.CarregarDepartamentoTabela(), cabecalho));
    }
    
    public  boolean preencherInformacao (){
        int row = tbDepartamento.getSelectedRow();
        if (tbDepartamento.getSelectedRow()!=-1){
            txtCod.setText(String.valueOf(tbDepartamento.getValueAt(row,0)));
            txtNome.setText(String.valueOf(tbDepartamento.getValueAt(row,1)));
            txtPercentual.setText(String.valueOf(tbDepartamento.getValueAt(row,2)));
            
        }
        return true;
       
    }
    
    public boolean bloquear() {
        txtCod.setEditable(false);
        txtNome.setEditable(false);
        txtPercentual.setEditable(false);
        btNovo.setEnabled(true);
        btSalvar.setEnabled(false);
        btExcluir.setEnabled(true);
        btEditar.setEnabled(true);
        btCancelar.setEnabled(false);
        btSair.setEnabled(true);
        return true;
    }
    
    public boolean desbloquear() {
        txtCod.setEditable(false);
        txtNome.setEditable(true);
        txtPercentual.setEditable(true);
        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
        btExcluir.setEnabled(false);
        btEditar.setEnabled(false);
        btCancelar.setEnabled(true);
        btSair.setEnabled(false);
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDepartamento;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPercentual;
    // End of variables declaration//GEN-END:variables
}