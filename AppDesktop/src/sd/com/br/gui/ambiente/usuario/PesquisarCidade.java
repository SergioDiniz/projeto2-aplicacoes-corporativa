/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.com.br.gui.ambiente.usuario;

import edu.ifpb.dac.Denuncia;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import sd.com.br.dao.DaoDenuncia;
import sd.com.br.gui.ModeloTabela;

/**
 *
 * @author Sergiod
 */
public class PesquisarCidade extends javax.swing.JPanel{

    /**
     * Creates new form PesquisarCidade
     */
    public PesquisarCidade() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTCidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTEstado = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPResultadoPesquisa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPesquisa = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisar Cidade");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Cidade");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        jTCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTCidade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jTCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 230, 33));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Sigla Estado");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, -1));

        jTEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jTEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 230, 33));

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.setPreferredSize(new java.awt.Dimension(150, 33));
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(jBPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 100, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 730, 10));

        jPResultadoPesquisa.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Resultado");

        jTPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTPesquisa);

        javax.swing.GroupLayout jPResultadoPesquisaLayout = new javax.swing.GroupLayout(jPResultadoPesquisa);
        jPResultadoPesquisa.setLayout(jPResultadoPesquisaLayout);
        jPResultadoPesquisaLayout.setHorizontalGroup(
            jPResultadoPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPResultadoPesquisaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPResultadoPesquisaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPResultadoPesquisaLayout.setVerticalGroup(
            jPResultadoPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPResultadoPesquisaLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel2.add(jPResultadoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 209, -1, 400));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 48, 1200, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        // TODO add your handling code here:
        
        if((jTCidade.getText().length() > 0) && (jTEstado.getText().length() > 0)){
            
            DaoDenuncia dd = new DaoDenuncia();
            
            List<Denuncia> denuncias = dd.pesquisarPorCidade(jTCidade.getText(), jTEstado.getText());
            
            if (denuncias != null){
                ArrayList dados = new ArrayList();
                String[] colunas = new String[]{"Descrição", "Endereço", "Acompanhamento"};
            
                for(int i = 0 ; i < denuncias.size() ;i++){
                    dados.add(new Object[]{denuncias.get(i).getDescricao(), denuncias.get(i).getEnderecoDenuncia().getRua() + ", nº " +
                    denuncias.get(i).getEnderecoDenuncia().getNumero() + ", " + denuncias.get(i).getEnderecoDenuncia().getBairro(),
                    denuncias.get(i).getEstadoDeAcompanhamento()});
                }

                ModeloTabela tabela = new ModeloTabela(dados, colunas);
                jTPesquisa.setModel(tabela);
                jTPesquisa.setRowHeight(40);
                jTPesquisa.getTableHeader().setReorderingAllowed(false);
                
                
            } else{
                JOptionPane.showMessageDialog(jPanel1, "Não foi Encontrado nenhum resultado!");
            }
            
            
            
            
            
            
        }else {
            JOptionPane.showMessageDialog(jPanel1, "Preencha todos os campos corretamente!");
        }
        
        
        
    }//GEN-LAST:event_jBPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPResultadoPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTCidade;
    private javax.swing.JTextField jTEstado;
    private javax.swing.JTable jTPesquisa;
    // End of variables declaration//GEN-END:variables

}
