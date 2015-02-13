/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.com.br.gui.ambiente.usuario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sd.com.br.beans.Denuncia;
import sd.com.br.dao.DaoUsuario;
import sd.com.br.gui.ModeloTabela;

/**
 *
 * @author Sergiod
 */
public class DenunciasRealizadas extends javax.swing.JPanel {

    /**
     * Creates new form DenunciasRealizadas
     */
    private String emailUsuaio;
    public DenunciasRealizadas(String emailUsuario) {
        this.emailUsuaio = emailUsuario;
        initComponents();
        minhasDenuncias();
    }
    
    public void minhasDenuncias(){
        
        DaoUsuario du = new DaoUsuario();
        
        List<Denuncia> denuncias = du.minhasDenuncias(emailUsuaio);
        
        if(denuncias != null){
            
            ArrayList dados = new ArrayList();
            String[] colunas = new String[]{"Descrição", "Cidade", "Endereço", "Acompanhamento"};

            for(int i = 0 ; i < denuncias.size() ;i++){
                dados.add(new Object[]{denuncias.get(i).getDescricao(), denuncias.get(i).getCidade().getCidadePK().getNomeCidade()
                + ", " + denuncias.get(i).getCidade().getCidadePK().getSiglaEstado(),
                denuncias.get(i).getEnderecoDenuncia().getRua() + ", nº " +
                denuncias.get(i).getEnderecoDenuncia().getNumero() + ", " + denuncias.get(i).getEnderecoDenuncia().getBairro(),
                denuncias.get(i).getEstadoDeAcompanhamento()});
            }

            ModeloTabela tabela = new ModeloTabela(dados, colunas);
            jTMinhasDenuncias.setModel(tabela);
            jTMinhasDenuncias.setRowHeight(40);
            jTMinhasDenuncias.getTableHeader().setReorderingAllowed(false);
            
            
            
        }else{
            JOptionPane.showMessageDialog(jPanel1, "Não foi Encontrado nenhum resultado!");
            jPMinhasDenuncias.setVisible(false);
            revalidate();
            repaint();
        }

        
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
        jLabel1 = new javax.swing.JLabel();
        jPMinhasDenuncias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMinhasDenuncias = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Minhas Denuncias");

        jPMinhasDenuncias.setBackground(new java.awt.Color(255, 255, 255));

        jTMinhasDenuncias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTMinhasDenuncias);

        javax.swing.GroupLayout jPMinhasDenunciasLayout = new javax.swing.GroupLayout(jPMinhasDenuncias);
        jPMinhasDenuncias.setLayout(jPMinhasDenunciasLayout);
        jPMinhasDenunciasLayout.setHorizontalGroup(
            jPMinhasDenunciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMinhasDenunciasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPMinhasDenunciasLayout.setVerticalGroup(
            jPMinhasDenunciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPMinhasDenuncias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPMinhasDenuncias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPMinhasDenuncias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTMinhasDenuncias;
    // End of variables declaration//GEN-END:variables
}