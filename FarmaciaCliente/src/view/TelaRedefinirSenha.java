package view;

import javax.swing.JOptionPane;
import modelDominio.Usuario;

public class TelaRedefinirSenha extends javax.swing.JFrame {

    public TelaRedefinirSenha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCentral = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jLSubtitulo1 = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jLUsuario = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jBEnviar = new javax.swing.JButton();
        jBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Redefinir Senha");
        setUndecorated(true);

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("Redefinir Senha");
        jLTitulo.setToolTipText("");

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo.setText("Insira seu usuário e e-mail, e enviaremos");

        jLSubtitulo1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo1.setText("um código para redefinir sua senha.");

        jTFUsuario.setBackground(new java.awt.Color(237, 237, 237));
        jTFUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(183, 183, 183));
        jLUsuario.setText("Usuário");

        jLEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLEmail.setForeground(new java.awt.Color(183, 183, 183));
        jLEmail.setText("E-mail");

        jTFEmail.setBackground(new java.awt.Color(237, 237, 237));
        jTFEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

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
                    .addComponent(jLSubtitulo)
                    .addComponent(jLTitulo)
                    .addComponent(jLSubtitulo1)
                    .addComponent(jLUsuario)
                    .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmail)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPCentralLayout.setVerticalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLTitulo))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jBVoltar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSubtitulo)
                .addGap(0, 0, 0)
                .addComponent(jLSubtitulo1)
                .addGap(40, 40, 40)
                .addComponent(jLUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
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
        // Validação das informações
        if (!jTFUsuario.getText().equals("")) {
            if (!jTFEmail.getText().equals("")) {
                // Obtendo as informações
                String login = jTFUsuario.getText();
                String email = jTFEmail.getText();
                // Criando o objeto da classe Usuario
                Usuario usuario = new Usuario(login, email, null);
                // Enviando a solicitação de validação da existência do Usuario
                boolean resultado = FarmaciaCliente.ccont.usuarioValidar(usuario);
                // Validação do resultado
                if (resultado == true) {
                    // Enviando o e-mail com o código
                    String codigo = FarmaciaCliente.ccont.enviarEmail(email);
                    // Chamando a próxima tela
                    TelaCodigoRedefinirSenha telaCodigoRedefinirSenha = new TelaCodigoRedefinirSenha(usuario, codigo);
                    telaCodigoRedefinirSenha.setVisible(true);
                    // Fechando a tela
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: usuário não cadastrado.");
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o e-mail.");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o usuário.");
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLSubtitulo1;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPanel jPCentral;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}
