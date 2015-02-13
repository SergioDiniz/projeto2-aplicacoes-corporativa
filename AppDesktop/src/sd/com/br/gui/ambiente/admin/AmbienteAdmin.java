/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.com.br.gui.ambiente.admin;

import edu.ifpb.dac.Administrador;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import sd.com.br.gui.BemVindo;
import sd.com.br.gui.Inicio;

/**
 *
 * @author SergioD
 */
public class AmbienteAdmin extends javax.swing.JFrame {

    /**
     * Creates new form AmbienteAdmin
     */
    
    private Inicio inicio;
    private Administrador administrador;
    
    public AmbienteAdmin(Inicio inicio, Administrador administrador) {
        this.administrador = administrador;
        this.inicio = inicio;
        initComponents();
        init();
        iniciarBotoes();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void init(){
        
        jPAreaTroca.removeAll();
        BemVindo bv = new BemVindo();
        bv.setVisible(true);
        bv.setBounds(0,0,1366,650);
        jPAreaTroca.add(bv);
        revalidate();
        repaint();          
    }
    
    public void iniciarBotoes(){
        Icon iconSolicitacoes = new ImageIcon("src/sd/com/br/gui/img/solicitacoesPendentes.jpg");
        Icon iconGerenciar = new ImageIcon("src/sd/com/br/gui/img/gerenciarestadoPrefeituras.jpg");
        Icon iconAtivos = new ImageIcon("src/sd/com/br/gui/img/prefeiturasAtivas.jpg");
        Icon iconConf = new ImageIcon("src/sd/com/br/gui/img/configuracoes.jpg");
        Icon iconSair = new ImageIcon("src/sd/com/br/gui/img/sair.jpg");
        
        jBSolicitacoesPendentes.setIcon(iconSolicitacoes);
        jBGerenciarEstado.setIcon(iconGerenciar);
        jBTodasPrefeitura.setIcon(iconAtivos);
        jBConfigurar.setIcon(iconConf);
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

        jPanel1 = new javax.swing.JPanel();
        jPAreaMenu = new javax.swing.JPanel();
        jBSair = new javax.swing.JButton();
        jBSolicitacoesPendentes = new javax.swing.JButton();
        jBGerenciarEstado = new javax.swing.JButton();
        jBTodasPrefeitura = new javax.swing.JButton();
        jBConfigurar = new javax.swing.JButton();
        jPAreaTroca = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPAreaMenu.setBackground(new java.awt.Color(102, 102, 102));

        jBSair.setToolTipText("Sair");
        jBSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jBSolicitacoesPendentes.setToolTipText("Solicitações Pendentes");
        jBSolicitacoesPendentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSolicitacoesPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSolicitacoesPendentesActionPerformed(evt);
            }
        });

        jBGerenciarEstado.setToolTipText("Gerenciar Estado das Prefeitura");
        jBGerenciarEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGerenciarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerenciarEstadoActionPerformed(evt);
            }
        });

        jBTodasPrefeitura.setToolTipText("Todas as Prefeituras Ativas");
        jBTodasPrefeitura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBTodasPrefeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTodasPrefeituraActionPerformed(evt);
            }
        });

        jBConfigurar.setToolTipText("Denuncia Conteudo Improprio em Denuncia");
        jBConfigurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfigurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAreaMenuLayout = new javax.swing.GroupLayout(jPAreaMenu);
        jPAreaMenu.setLayout(jPAreaMenuLayout);
        jPAreaMenuLayout.setHorizontalGroup(
            jPAreaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAreaMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSolicitacoesPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBGerenciarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBTodasPrefeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPAreaMenuLayout.setVerticalGroup(
            jPAreaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAreaMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPAreaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSolicitacoesPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGerenciarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTodasPrefeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPAreaTroca.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPAreaTrocaLayout = new javax.swing.GroupLayout(jPAreaTroca);
        jPAreaTroca.setLayout(jPAreaTrocaLayout);
        jPAreaTrocaLayout.setHorizontalGroup(
            jPAreaTrocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPAreaTrocaLayout.setVerticalGroup(
            jPAreaTrocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPAreaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPAreaTroca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPAreaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPAreaTroca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        // TODO add your handling code here:

        dispose();
        new Inicio().setVisible(true);

    }//GEN-LAST:event_jBSairActionPerformed

    private void jBSolicitacoesPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSolicitacoesPendentesActionPerformed
        // TODO add your handling code here:
        
        jPAreaTroca.removeAll();
        SolicitacoesPendentes sp = new SolicitacoesPendentes();
        sp.setVisible(true);
        sp.setBounds(0,0,1366,600);
        jPAreaTroca.add(sp);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_jBSolicitacoesPendentesActionPerformed

    private void jBGerenciarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerenciarEstadoActionPerformed
        // TODO add your handling code here:
        jPAreaTroca.removeAll();
        GerenciarSolicitacao gs = new GerenciarSolicitacao();
        gs.setVisible(true);
        gs.setBounds(0,0,1366,600);
        jPAreaTroca.add(gs);
        revalidate();
        repaint();        
    }//GEN-LAST:event_jBGerenciarEstadoActionPerformed

    private void jBTodasPrefeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTodasPrefeituraActionPerformed
        // TODO add your handling code here:
        
        jPAreaTroca.removeAll();
        TodasPrefeituras tp = new TodasPrefeituras();
        tp.setVisible(true);
        tp.setBounds(0,0,1366,600);
        jPAreaTroca.add(tp);
        revalidate();
        repaint();
        
    }//GEN-LAST:event_jBTodasPrefeituraActionPerformed

    private void jBConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfigurarActionPerformed
        // TODO add your handling code here:

        jPAreaTroca.removeAll();
        ConfiguracoesAdmin ca = new ConfiguracoesAdmin(administrador);
        ca.setVisible(true);
        ca.setBounds(0,0,1366,600);
        jPAreaTroca.add(ca);
        revalidate();
        repaint();

    }//GEN-LAST:event_jBConfigurarActionPerformed

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
            java.util.logging.Logger.getLogger(AmbienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmbienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmbienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmbienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmbienteAdmin(new Inicio(), new Administrador() ).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConfigurar;
    private javax.swing.JButton jBGerenciarEstado;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSolicitacoesPendentes;
    private javax.swing.JButton jBTodasPrefeitura;
    private javax.swing.JPanel jPAreaMenu;
    private javax.swing.JPanel jPAreaTroca;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
