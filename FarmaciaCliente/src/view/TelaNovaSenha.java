package view;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import modelDominio.Usuario;
import view.util.Hash;

public class TelaNovaSenha extends javax.swing.JFrame {
    private Usuario usuario;

    public TelaNovaSenha(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCentral = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jBRedefinirSenha = new javax.swing.JButton();
        jBVoltar = new javax.swing.JButton();
        jPFConfirmarSenha = new javax.swing.JPasswordField();
        jPFSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Redefinir Senha");
        setUndecorated(true);

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("Nova Senha");
        jLTitulo.setToolTipText("");

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo.setText("Insira sua nova senha.");

        jLUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(183, 183, 183));
        jLUsuario.setText("Senha");

        jLEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLEmail.setForeground(new java.awt.Color(183, 183, 183));
        jLEmail.setText("Confirmar senha");

        jBRedefinirSenha.setBackground(new java.awt.Color(33, 31, 104));
        jBRedefinirSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBRedefinirSenha.setForeground(new java.awt.Color(252, 252, 252));
        jBRedefinirSenha.setText("Redefinir Senha");
        jBRedefinirSenha.setBorder(null);
        jBRedefinirSenha.setBorderPainted(false);
        jBRedefinirSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBRedefinirSenha.setRequestFocusEnabled(false);
        jBRedefinirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRedefinirSenhaActionPerformed(evt);
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

        jPFConfirmarSenha.setBackground(new java.awt.Color(237, 237, 237));
        jPFConfirmarSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jPFSenha.setBackground(new java.awt.Color(237, 237, 237));
        jPFSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        javax.swing.GroupLayout jPCentralLayout = new javax.swing.GroupLayout(jPCentral);
        jPCentral.setLayout(jPCentralLayout);
        jPCentralLayout.setHorizontalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jBVoltar)
                .addGap(112, 112, 112)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPFSenha)
                    .addComponent(jPFConfirmarSenha)
                    .addComponent(jBRedefinirSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSubtitulo)
                            .addComponent(jLTitulo)
                            .addComponent(jLUsuario)
                            .addComponent(jLEmail))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(164, 164, 164))
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
                .addGap(58, 58, 58)
                .addComponent(jLUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBRedefinirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jBRedefinirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRedefinirSenhaActionPerformed
        // Validação das informações
        String senha = new String(jPFSenha.getPassword());
        String confirmarSenha = new String(jPFConfirmarSenha.getPassword());
        if (!senha.equals("")) {
            if (!confirmarSenha.equals("")) {
                if (senha.equals(confirmarSenha)) {
                    // Criptografando a senha
                    try {
                        senha = Hash.encriptar(senha, "MD5");
                    }
                    catch (NoSuchAlgorithmException nsae) {
                        System.out.println("Erro: " + nsae.getMessage());
                    }
                    catch (UnsupportedEncodingException uee) {
                        System.out.println("Erro: " + uee.getMessage());
                    }
                    // Obtendo as informações
                    String login = usuario.getLogin();
                    String email = usuario.getEmail();
                    // Criando o objeto da classe Usuario
                    Usuario usuario = new Usuario(login, email, senha);
                    // Enviando a solicitação de Redefinir Senha
                    boolean resultado = FarmaciaCliente.ccont.redefinirSenha(usuario);
                    // Validação do resultado
                    if (resultado == true) {
                        // Fechando a tela
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível redefinir a senha.");
                    }
                }
                else {
                    JOptionPane.showConfirmDialog(rootPane, "Erro: as senhas informadas não correspondem.");
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o e-mail.");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o usuário.");
        }
    }//GEN-LAST:event_jBRedefinirSenhaActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRedefinirSenha;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPanel jPCentral;
    private javax.swing.JPasswordField jPFConfirmarSenha;
    private javax.swing.JPasswordField jPFSenha;
    // End of variables declaration//GEN-END:variables
}
