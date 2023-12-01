package view;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import modelDominio.Cliente;
import modelDominio.Usuario;
import view.util.Hash;

public class TelaCadastroClientes extends javax.swing.JDialog {

    public TelaCadastroClientes() {
        initComponents();
        jTFNome.grabFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCentral = new javax.swing.JPanel();
        jBVoltar = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLCpf = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jFTFCpf = new javax.swing.JFormattedTextField();
        jBCadastrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLTelefone = new javax.swing.JLabel();
        jFTFTelefone = new javax.swing.JFormattedTextField();
        jLEndereco = new javax.swing.JLabel();
        jTFEndereco = new javax.swing.JTextField();
        jLlogin = new javax.swing.JLabel();
        jTFLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();
        jLNumero = new javax.swing.JLabel();
        jTFNumero = new javax.swing.JTextField();
        jLBairro = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Cadastro de Clientes");
        setUndecorated(true);

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));

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

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("Cadastro");
        jLTitulo.setToolTipText("");

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo.setText("Realize o cadastro do cliente da sua farmácia.");

        jLNome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLNome.setForeground(new java.awt.Color(183, 183, 183));
        jLNome.setText("Nome");

        jTFNome.setBackground(new java.awt.Color(237, 237, 237));
        jTFNome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLCpf.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLCpf.setForeground(new java.awt.Color(183, 183, 183));
        jLCpf.setText("CPF");

        jLEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLEmail.setForeground(new java.awt.Color(183, 183, 183));
        jLEmail.setText("E-mail");

        jTFEmail.setBackground(new java.awt.Color(237, 237, 237));
        jTFEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jFTFCpf.setBackground(new java.awt.Color(237, 237, 237));
        jFTFCpf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        try {
            jFTFCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jBCadastrar.setBackground(new java.awt.Color(33, 31, 104));
        jBCadastrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.setBorderPainted(false);
        jBCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastrar.setRequestFocusEnabled(false);
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(237, 237, 237));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLTelefone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLTelefone.setForeground(new java.awt.Color(183, 183, 183));
        jLTelefone.setText("Telefone");

        jFTFTelefone.setBackground(new java.awt.Color(237, 237, 237));
        jFTFTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        try {
            jFTFTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLEndereco.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLEndereco.setForeground(new java.awt.Color(183, 183, 183));
        jLEndereco.setText("Endereço");

        jTFEndereco.setBackground(new java.awt.Color(237, 237, 237));
        jTFEndereco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLlogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLlogin.setForeground(new java.awt.Color(183, 183, 183));
        jLlogin.setText("Login");

        jTFLogin.setBackground(new java.awt.Color(237, 237, 237));
        jTFLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSenha.setForeground(new java.awt.Color(183, 183, 183));
        jLSenha.setText("Senha");

        jPFSenha.setBackground(new java.awt.Color(237, 237, 237));
        jPFSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLNumero.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLNumero.setForeground(new java.awt.Color(183, 183, 183));
        jLNumero.setText("Número");

        jTFNumero.setBackground(new java.awt.Color(237, 237, 237));
        jTFNumero.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLBairro.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLBairro.setForeground(new java.awt.Color(183, 183, 183));
        jLBairro.setText("Bairro");

        jTFBairro.setBackground(new java.awt.Color(237, 237, 237));
        jTFBairro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        javax.swing.GroupLayout jPCentralLayout = new javax.swing.GroupLayout(jPCentral);
        jPCentral.setLayout(jPCentralLayout);
        jPCentralLayout.setHorizontalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jBVoltar))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLCpf)
                            .addComponent(jLSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTitulo)
                            .addComponent(jLNome)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLEmail)
                            .addComponent(jTFEmail)
                            .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLTelefone)
                            .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLEndereco)
                            .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLlogin)
                            .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLSenha)
                            .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLNumero)
                            .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLBairro)
                            .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPCentralLayout.setVerticalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jBVoltar)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCentralLayout.createSequentialGroup()
                                .addGap(416, 416, 416)
                                .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCentralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLlogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPCentralLayout.createSequentialGroup()
                            .addComponent(jLTitulo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLSubtitulo)
                            .addGap(43, 43, 43)
                            .addComponent(jLNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLCpf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        // Validação das informações
        if (!jTFNome.getText().equals("")) {
            if (!jFTFCpf.getText().equals("   .   .   -  ")) {
                if (!jTFEmail.getText().equals("")) {
                    if (!jFTFTelefone.getText().equals("(  )      -    ")) {
                        if (!jTFEndereco.getText().equals("")) {
                            if (!jTFNumero.getText().equals("")) {
                                if (!jTFBairro.getText().equals("")) {
                                    if (!jTFLogin.getText().equals("")) {
                                        if (!jPFSenha.getPassword().equals("")) {
                                            // Obtendo as informações
                                            String nome = jTFNome.getText();
                                            String cpf = jFTFCpf.getText();
                                            String email = jTFEmail.getText();
                                            String telefone = jFTFTelefone.getText();
                                            String endereco = jTFEndereco.getText();
                                            String numero = jTFNumero.getText();
                                            String bairro = jTFBairro.getText();
                                            String login = jTFLogin.getText();
                                            String senha = new String(jPFSenha.getPassword());
                                            // Montando o endereço
                                            String enderecoCompleto = (endereco + ", " + numero + ", " + bairro);
                                            // Criptografando a senha
                                            try {
                                                senha = Hash.encriptar(senha, "MD5");
                                            }
                                            catch (NoSuchAlgorithmException nsae) {
                                                JOptionPane.showMessageDialog(rootPane, "Erro: " + nsae.getMessage());
                                            }
                                            catch (UnsupportedEncodingException uee) {
                                                JOptionPane.showMessageDialog(rootPane, "Erro: " + uee.getMessage());
                                            }
                                            // Criando o objeto da classe Cliente
                                            Usuario usuario = new Cliente(nome, cpf, email, telefone, enderecoCompleto, login, senha);
                                            // Enviando a solicitação de cadastro de Usuario
                                            boolean resultado = FarmaciaCliente.ccont.usuarioInserir(usuario);
                                            // Validação do resultado
                                            if (resultado == true) {
                                                JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso.");
                                            }
                                            else {
                                                JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível cadastrar o cliente.");
                                            }
                                            limpaCampos();
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(rootPane, "Erro: informe a senha.");
                                        }
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(rootPane, "Erro: informe o login.");
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(rootPane, "Erro: informe o bairro.");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(rootPane, "Erro: informe o número.");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "Erro: informe o endereço.");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "Erro: informe o telefone.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: informe o e-mail.");
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o CPF.");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o nome.");
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    public void limpaCampos() {
        jTFNome.setText("");
        jFTFCpf.setText("");
        jTFEmail.setText("");
        jFTFTelefone.setText("");
        jTFEndereco.setText("");
        jTFNumero.setText("");
        jTFBairro.setText("");
        jTFLogin.setText("");
        jPFSenha.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JFormattedTextField jFTFCpf;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLlogin;
    private javax.swing.JPanel jPCentral;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFLogin;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNumero;
    // End of variables declaration//GEN-END:variables
}
