package view;

import javax.swing.JOptionPane;
import modelDominio.Usuario;

public class TelaCodigoRedefinirSenha extends javax.swing.JFrame {
    private Usuario usuario;
    private String codigo;

    public TelaCodigoRedefinirSenha(Usuario usuario, String codigo) {
        initComponents();
        this.usuario = usuario;
        this.codigo = codigo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCentral = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jTFCódigo = new javax.swing.JTextField();
        jLCodigo = new javax.swing.JLabel();
        jBEnviar = new javax.swing.JButton();
        jBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Redefinir Senha");
        setUndecorated(true);

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("Confirmação");
        jLTitulo.setToolTipText("");

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo.setText("Um código foi enviado para seu e-mail.");

        jTFCódigo.setBackground(new java.awt.Color(237, 237, 237));
        jTFCódigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLCodigo.setForeground(new java.awt.Color(183, 183, 183));
        jLCodigo.setText("Código");

        jBEnviar.setBackground(new java.awt.Color(33, 31, 104));
        jBEnviar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBEnviar.setForeground(new java.awt.Color(252, 252, 252));
        jBEnviar.setText("Enviar");
        jBEnviar.setBorder(null);
        jBEnviar.setBorderPainted(false);
        jBEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEnviar.setRequestFocusEnabled(false);
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        jBVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBVoltar.setBorderPainted(false);
        jBVoltar.setContentAreaFilled(false);
        jBVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBVoltar.setFocusable(false);
        jBVoltar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jBVoltar.setRequestFocusEnabled(false);
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCentralLayout = new javax.swing.GroupLayout(jPCentral);
        jPCentral.setLayout(jPCentralLayout);
        jPCentralLayout.setHorizontalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jBVoltar)
                .addGap(112, 112, 112)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jTFCódigo)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSubtitulo)
                            .addComponent(jLTitulo)
                            .addComponent(jLCodigo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(164, 164, 164))
        );
        jPCentralLayout.setVerticalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLTitulo))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jBVoltar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSubtitulo)
                .addGap(58, 58, 58)
                .addComponent(jLCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFCódigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        // Validação do código
        if (!jTFCódigo.getText().equals("")) {
            // Obtendo o código
            String codigo = jTFCódigo.getText();
            // Validação do código de confirmação
            if (codigo.equals(this.codigo)) {
                // Chamando a próxima tela
                TelaNovaSenha telaNovaSenha = new TelaNovaSenha(usuario);
                telaNovaSenha.setVisible(true);
                // Fechando a tela
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: código incorreto.");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o código.");
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLCodigo;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JPanel jPCentral;
    private javax.swing.JTextField jTFCódigo;
    // End of variables declaration//GEN-END:variables
}
