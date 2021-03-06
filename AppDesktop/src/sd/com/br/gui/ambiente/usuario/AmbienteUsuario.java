/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.com.br.gui.ambiente.usuario;

import edu.ifpb.dac.Usuario;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sd.com.br.gui.*;

/**
 *
 * @author Sergiod
 */
public class AmbienteUsuario extends javax.swing.JFrame {

    /**
     * Creates new form AmbienteUsuario
     */
    
    private Usuario usuario;
    
    public AmbienteUsuario(Usuario usuario) {
        
        this.usuario = usuario;
        
       
        initComponents();
        init();
        iniciarBotoes();
        
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public void init(){
        jLNome.setText(usuario.getNickname());
        
        jPAreaTroca.removeAll();
        BemVindo bv = new BemVindo();
        bv.setVisible(true);
        bv.setBounds(0,0,1235,630);
        jPAreaTroca.add(bv);
        revalidate();
        repaint();
        
    }
    
    public void iniciarBotoes(){
        Icon iconEscrever = new ImageIcon("src/sd/com/br/gui/img/escrever.jpg");
        Icon iconPesquisar = new ImageIcon("src/sd/com/br/gui/img/pesquisar.jpg");
        Icon iconRealizadas = new ImageIcon("src/sd/com/br/gui/img/realizadas.jpg");
        Icon iconSair = new ImageIcon("src/sd/com/br/gui/img/sair.jpg");
        Icon iconLogo = new ImageIcon("src/sd/com/br/gui/img/logo.png");
        Icon iconConfig = new ImageIcon("src/sd/com/br/gui/img/configuracoes.jpg");
        
        jBNovaDenuncia.setIcon(iconEscrever);
        jBPesquisarCidade.setIcon(iconPesquisar);
        jBDenunciasRealizadas.setIcon(iconRealizadas);
        jBConfiguracoes.setIcon(iconConfig);
        jLLogo.setIcon(iconLogo);
        jBSair.setIcon(iconSair);        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPConteiner = new javax.swing.JPanel();
        jPAreaTroca = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jBNovaDenuncia = new javax.swing.JButton();
        jBPesquisarCidade = new javax.swing.JButton();
        jBDenunciasRealizadas = new javax.swing.JButton();
        jBConfiguracoes = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPConteiner.setBackground(new java.awt.Color(255, 255, 255));
        jPConteiner.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPAreaTroca.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPAreaTrocaLayout = new javax.swing.GroupLayout(jPAreaTroca);
        jPAreaTroca.setLayout(jPAreaTrocaLayout);
        jPAreaTrocaLayout.setHorizontalGroup(
            jPAreaTrocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        jPAreaTrocaLayout.setVerticalGroup(
            jPAreaTrocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jBNovaDenuncia.setToolTipText("Nova Denuncia");
        jBNovaDenuncia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBNovaDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovaDenunciaActionPerformed(evt);
            }
        });

        jBPesquisarCidade.setToolTipText("Pesquisar Cidade");
        jBPesquisarCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBPesquisarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarCidadeActionPerformed(evt);
            }
        });

        jBDenunciasRealizadas.setToolTipText("Denuncias Realizadas");
        jBDenunciasRealizadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBDenunciasRealizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDenunciasRealizadasActionPerformed(evt);
            }
        });

        jBConfiguracoes.setToolTipText("Configurações");
        jBConfiguracoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfiguracoesActionPerformed(evt);
            }
        });

        jBSair.setToolTipText("Sair");
        jBSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDenunciasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNovaDenuncia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBNovaDenuncia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPesquisarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBDenunciasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Bem-Vindo");

        jLNome.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLNome.setForeground(new java.awt.Color(255, 208, 0));
        jLNome.setText("Sergio Diniz");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLNome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLNome)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPConteinerLayout = new javax.swing.GroupLayout(jPConteiner);
        jPConteiner.setLayout(jPConteinerLayout);
        jPConteinerLayout.setHorizontalGroup(
            jPConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPConteinerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPAreaTroca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPConteinerLayout.setVerticalGroup(
            jPConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPConteinerLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAreaTroca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPConteiner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        // TODO add your handling code here:

        dispose();
        new Inicio().setVisible(true);

    }//GEN-LAST:event_jBSairActionPerformed

    private void jBNovaDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovaDenunciaActionPerformed
        // TODO add your handling code here:

        jPAreaTroca.removeAll();
        NovaDenuncia nd = new NovaDenuncia(usuario);
        nd.setVisible(true);
        nd.setBounds(0,0,1200,600);
        jPAreaTroca.add(nd);
        revalidate();
        repaint();

    }//GEN-LAST:event_jBNovaDenunciaActionPerformed

    private void jBPesquisarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarCidadeActionPerformed
        // TODO add your handling code here:
        
        jPAreaTroca.removeAll();
        PesquisarCidade pc = new PesquisarCidade();
        pc.setVisible(true);
        pc.setBounds(0,0,1200,600);
        jPAreaTroca.add(pc);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_jBPesquisarCidadeActionPerformed

    private void jBDenunciasRealizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDenunciasRealizadasActionPerformed
        // TODO add your handling code here:
        
        jPAreaTroca.removeAll();
        DenunciasRealizadas dr = new DenunciasRealizadas(usuario.getEmail());
        dr.setVisible(true);
        dr.setBounds(0,0,1200,600);
        jPAreaTroca.add(dr);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_jBDenunciasRealizadasActionPerformed

    private void jBConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfiguracoesActionPerformed
        // TODO add your handling code here:
        
        jPAreaTroca.removeAll();
        ConfiguracoesUsuario conf = new ConfiguracoesUsuario(usuario, this);
        conf.setVisible(true);
        conf.setBounds(0,0,1200,600);
        jPAreaTroca.add(conf);
        revalidate();
        repaint();        
        
    }//GEN-LAST:event_jBConfiguracoesActionPerformed

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
            java.util.logging.Logger.getLogger(AmbienteUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmbienteUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmbienteUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmbienteUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmbienteUsuario(new Usuario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConfiguracoes;
    private javax.swing.JButton jBDenunciasRealizadas;
    private javax.swing.JButton jBNovaDenuncia;
    private javax.swing.JButton jBPesquisarCidade;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPAreaTroca;
    private javax.swing.JPanel jPConteiner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
