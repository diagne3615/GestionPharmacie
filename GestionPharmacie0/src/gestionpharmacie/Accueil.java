/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpharmacie;

import javax.swing.ImageIcon;

/**
 *
 * @author djira
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    public Accueil() {
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

        btnpharmacie = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1366, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnpharmacie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestionpharmacie/espace.png"))); // NOI18N
        btnpharmacie.setText("jLabel3");
        btnpharmacie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpharmacieMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnpharmacieMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnpharmacieMouseExited(evt);
            }
        });
        getContentPane().add(btnpharmacie, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 200, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestionpharmacie/accueil_1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnpharmacieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpharmacieMouseClicked
        // TODO add your handling code here:
         dispose();
        new MaPharmacie().setVisible(true);
    }//GEN-LAST:event_btnpharmacieMouseClicked

    private void btnpharmacieMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpharmacieMouseEntered
        // TODO add your handling code here:
        ImageIcon img = new ImageIcon(getClass().getResource("espaceH.png"));
        btnpharmacie.setIcon(img);
    }//GEN-LAST:event_btnpharmacieMouseEntered

    private void btnpharmacieMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpharmacieMouseExited
        // TODO add your handling code here:
        ImageIcon img = new ImageIcon(getClass().getResource("espace.png"));
        btnpharmacie.setIcon(img);
    }//GEN-LAST:event_btnpharmacieMouseExited

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnpharmacie;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
