package view;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import modelDominio.Cliente;
import modelDominio.Colaborador;
import view.util.Hash;
import modelDominio.Usuario;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLUsuario = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jPFSenha = new javax.swing.JPasswordField();
        jLSenha = new javax.swing.JLabel();
        jBEntrar = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jBSair = new javax.swing.JButton();
        jBRedefinirSenha = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iPharma - Tela de Login");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(183, 183, 183));
        jLUsuario.setText("Usuário");

        jTFUsuario.setBackground(new java.awt.Color(237, 237, 237));
        jTFUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jPFSenha.setBackground(new java.awt.Color(237, 237, 237));
        jPFSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSenha.setForeground(new java.awt.Color(183, 183, 183));
        jLSenha.setText("Senha");

        jBEntrar.setBackground(new java.awt.Color(33, 31, 104));
        jBEntrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBEntrar.setForeground(new java.awt.Color(252, 252, 252));
        jBEntrar.setText("Entrar");
        jBEntrar.setBorder(null);
        jBEntrar.setBorderPainted(false);
        jBEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEntrar.setRequestFocusEnabled(false);
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("Login");
        jLTitulo.setToolTipText("");

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo.setText("Bem-vindo! Faça login na sua conta.");

        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/sair.png"))); // NOI18N
        jBSair.setBorderPainted(false);
        jBSair.setContentAreaFilled(false);
        jBSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSair.setFocusable(false);
        jBSair.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jBSair.setRequestFocusEnabled(false);
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jBRedefinirSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBRedefinirSenha.setText("Esqueceu sua senha? Redefinir senha.");
        jBRedefinirSenha.setBorder(null);
        jBRedefinirSenha.setBorderPainted(false);
        jBRedefinirSenha.setContentAreaFilled(false);
        jBRedefinirSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBRedefinirSenha.setFocusPainted(false);
        jBRedefinirSenha.setRequestFocusEnabled(false);
        jBRedefinirSenha.setVerifyInputWhenFocusTarget(false);
        jBRedefinirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRedefinirSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLSubtitulo)
                            .addComponent(jLTitulo)
                            .addComponent(jLUsuario)
                            .addComponent(jLSenha)
                            .addComponent(jTFUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jPFSenha)
                            .addComponent(jBEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBSair)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jBRedefinirSenha)
                .addGap(0, 129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSair)
                .addGap(47, 47, 47)
                .addComponent(jLTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLSubtitulo)
                .addGap(53, 53, 53)
                .addComponent(jLUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRedefinirSenha)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 480, 600));

        jPanel2.setBackground(new java.awt.Color(33, 31, 104));

        jLImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/iPharma.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        // Validação dos dados
        String senha = new String(jPFSenha.getPassword());
        if (!jTFUsuario.getText().equals("")) {
            if (!senha.equals("")) {
                // Obtendo as informações
                String login = jTFUsuario.getText();
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
                // Instanciando o usuário
                Usuario usuario = new Usuario(login, senha);
                // Enviando a solicitação de autênticação ao servidor
                Usuario usuarioLogado = FarmaciaCliente.ccont.efetuarLogin(usuario);
                // Verificando o retorno do servidor
                if (usuarioLogado instanceof Colaborador) {
                    // Salvando o usuário logado
                    FarmaciaCliente.ccont.usuarioLogado = usuarioLogado;
                    // Chamando a Tela de Menu
                    TelaMenu telaMenu = new TelaMenu();
                    telaMenu.setVisible(true);
                    // Fechando a Tela Login
                    dispose();
                }
                else if (usuarioLogado instanceof Cliente) {
                    JOptionPane.showMessageDialog(rootPane, "Erro: acesso negado.");
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: usuario e/ou senha inválidos.");
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe a senha.");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o usuário.");
        }
    }//GEN-LAST:event_jBEntrarActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        FarmaciaCliente.ccont.fim();
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBRedefinirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRedefinirSenhaActionPerformed
        // Chamando a tela de Redefinir Senha
        TelaRedefinirSenha telaRedefinirSenha = new TelaRedefinirSenha();
        telaRedefinirSenha.setVisible(true);
        
    }//GEN-LAST:event_jBRedefinirSenhaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEntrar;
    private javax.swing.JButton jBRedefinirSenha;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLImagem;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}
