package view;

import javax.swing.JOptionPane;
import modelDominio.Cosmetico;
import modelDominio.Medicamento;
import modelDominio.Produto;
import view.util.Imagem;

public class TelaDetalhamentoProdutos extends javax.swing.JDialog {
    // Produto que será utilizado no Alterar ou Excluir
    private Produto produto;

    public TelaDetalhamentoProdutos(Produto produto) {
        initComponents();
        // Instanciando o Produto
        this.produto = produto;
        // Obtendo a imagem do Produto
        Imagem imagem = new Imagem(produto.getImagem());
        // Carregando a imagem
        jLImagem.setIcon(imagem.getImageIcon());
        // Verificação do tipo do Produto
        if (produto instanceof Medicamento) {
            // Habilitando os campos de Medicamento
            jLPrimeiroCampoVariavel.setText("Princípio aitvo:");
            jLSegundoCampoVariavel.setText("Dosagem (mg):");
            jLTerceiroCampoVariavel.setText("Laboratório:");
            // Carregando as informações
            jLDetalhamentoTipo.setText("Medicamento");
            jLDetalhamentoNome.setText(produto.getNome());
            jLDetalhamentoPreco.setText("R$ " + produto.getPrecoString(produto.getPreco()));
            jLDetalhamentoQuantidade.setText(Integer.toString(produto.getQuantidade()));
            jLDetalhamentoPrimeiroCampoVariavel.setText(((Medicamento) produto).getPrincipioAtivo());
            jLDetalhamentoSegundoCampoVariavel.setText(((Medicamento) produto).getDosagem());
            jLDetalhamentoTerceiroCampoVariavel.setText(((Medicamento) produto).getLaboratorio());
        }
        else {
            // Habilitando os campos de Cosmético
            jLPrimeiroCampoVariavel.setText("Marca:");
            jLSegundoCampoVariavel.setText("Volume (mL):");
            jLTerceiroCampoVariavel.setVisible(false);
            jLDetalhamentoTerceiroCampoVariavel.setVisible(false);
            // Carregando as informações
            jLDetalhamentoTipo.setText("Cosmético");
            jLDetalhamentoNome.setText(produto.getNome());
            jLDetalhamentoPreco.setText("R$ " + produto.getPrecoString(produto.getPreco()));
            jLDetalhamentoQuantidade.setText(Integer.toString(produto.getQuantidade()));
            jLDetalhamentoPrimeiroCampoVariavel.setText(((Cosmetico) produto).getMarca());
            jLDetalhamentoSegundoCampoVariavel.setText(Float.toString(((Cosmetico) produto).getVolume()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCentral = new javax.swing.JPanel();
        jLDetalhamentoNome = new javax.swing.JLabel();
        jLDetalhamentoPreco = new javax.swing.JLabel();
        jLDetalhamentoQuantidade = new javax.swing.JLabel();
        jLDetalhamentoPrimeiroCampoVariavel = new javax.swing.JLabel();
        jLDetalhamentoSegundoCampoVariavel = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLDetalhamentoTerceiroCampoVariavel = new javax.swing.JLabel();
        jLPreco = new javax.swing.JLabel();
        jLTipo = new javax.swing.JLabel();
        jLQuantidade = new javax.swing.JLabel();
        jLDetalhamentoTipo = new javax.swing.JLabel();
        jLPrimeiroCampoVariavel = new javax.swing.JLabel();
        jBEditar = new javax.swing.JButton();
        jLSegundoCampoVariavel = new javax.swing.JLabel();
        jBExcluir = new javax.swing.JButton();
        jLTerceiroCampoVariavel = new javax.swing.JLabel();
        jLImagem = new javax.swing.JLabel();
        jBVoltar4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Detalhamento de Produto");
        setUndecorated(true);

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));
        jPCentral.setPreferredSize(new java.awt.Dimension(400, 400));

        jLDetalhamentoNome.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoNome.setText("jLabel1");

        jLDetalhamentoPreco.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoPreco.setText("jLabel2");

        jLDetalhamentoQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoQuantidade.setText("jLabel3");

        jLDetalhamentoPrimeiroCampoVariavel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoPrimeiroCampoVariavel.setText("jLabel4");

        jLDetalhamentoSegundoCampoVariavel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoSegundoCampoVariavel.setText("jLabel5");

        jLNome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLNome.setForeground(new java.awt.Color(183, 183, 183));
        jLNome.setText("Nome:");
        jLNome.setToolTipText("");

        jLDetalhamentoTerceiroCampoVariavel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoTerceiroCampoVariavel.setText("jLabel6");

        jLPreco.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLPreco.setForeground(new java.awt.Color(183, 183, 183));
        jLPreco.setText("Preço:");

        jLTipo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLTipo.setForeground(new java.awt.Color(183, 183, 183));
        jLTipo.setText("Tipo:");

        jLQuantidade.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLQuantidade.setForeground(new java.awt.Color(183, 183, 183));
        jLQuantidade.setText("Quantidade:");

        jLDetalhamentoTipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLDetalhamentoTipo.setText("jLabel1");

        jLPrimeiroCampoVariavel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLPrimeiroCampoVariavel.setForeground(new java.awt.Color(183, 183, 183));
        jLPrimeiroCampoVariavel.setText("PrimeiroCampoVariavel");

        jBEditar.setBackground(new java.awt.Color(33, 31, 104));
        jBEditar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBEditar.setForeground(new java.awt.Color(255, 255, 255));
        jBEditar.setText("Editar");
        jBEditar.setBorder(null);
        jBEditar.setBorderPainted(false);
        jBEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEditar.setFocusable(false);
        jBEditar.setRequestFocusEnabled(false);
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jLSegundoCampoVariavel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSegundoCampoVariavel.setForeground(new java.awt.Color(183, 183, 183));
        jLSegundoCampoVariavel.setText("SegundoCampoVariavel");

        jBExcluir.setBackground(new java.awt.Color(33, 31, 104));
        jBExcluir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluir.setText("Excluir");
        jBExcluir.setBorder(null);
        jBExcluir.setBorderPainted(false);
        jBExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBExcluir.setFocusable(false);
        jBExcluir.setRequestFocusEnabled(false);
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jLTerceiroCampoVariavel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLTerceiroCampoVariavel.setForeground(new java.awt.Color(183, 183, 183));
        jLTerceiroCampoVariavel.setText("TerceiroCampoVariavel");

        jBVoltar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBVoltar4.setBorderPainted(false);
        jBVoltar4.setContentAreaFilled(false);
        jBVoltar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBVoltar4.setFocusable(false);
        jBVoltar4.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jBVoltar4.setRequestFocusEnabled(false);
        jBVoltar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCentralLayout = new javax.swing.GroupLayout(jPCentral);
        jPCentral.setLayout(jPCentralLayout);
        jPCentralLayout.setHorizontalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLTerceiroCampoVariavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoTerceiroCampoVariavel))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoTipo))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoNome))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoPreco))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoQuantidade))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLPrimeiroCampoVariavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoPrimeiroCampoVariavel))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addComponent(jLSegundoCampoVariavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDetalhamentoSegundoCampoVariavel)))
                .addGap(8, 8, 8)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addGap(79, 79, 79))
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jBVoltar4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCentralLayout.setVerticalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCentralLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jBVoltar4)
                .addGap(33, 33, 33)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTipo)
                            .addComponent(jLDetalhamentoTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNome)
                            .addComponent(jLDetalhamentoNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPreco)
                            .addComponent(jLDetalhamentoPreco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLQuantidade)
                            .addComponent(jLDetalhamentoQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPrimeiroCampoVariavel)
                            .addComponent(jLDetalhamentoPrimeiroCampoVariavel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLSegundoCampoVariavel)
                            .addComponent(jLDetalhamentoSegundoCampoVariavel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTerceiroCampoVariavel)
                            .addComponent(jLDetalhamentoTerceiroCampoVariavel)))
                    .addComponent(jLImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // Chamando a Tela de Gerenciamento de Produtos
        TelaCadastroProdutos telaCadastroProdutos = new TelaCadastroProdutos(produto);
        dispose();
        telaCadastroProdutos.setModal(true);
        telaCadastroProdutos.setVisible(true);
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // Confirmando a exclusão 
        int resposta = JOptionPane.showConfirmDialog(rootPane,
                "Deseja excluir o produto?",
                "Excluir",
                JOptionPane.YES_NO_OPTION);
        // Validação da resposta
        if (resposta == JOptionPane.YES_OPTION) {
            // Enviando a solicitação de exclusão de Produto ao servidor
            boolean resultado = FarmaciaCliente.ccont.produtoExcluir(produto);
            // Validação do resultado
            if (resultado == true) {
                JOptionPane.showMessageDialog(rootPane, "Produto excluído com sucesso.");
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível excluir o produto.");
            }
            dispose();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBVoltar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltar4ActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltar4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBVoltar4;
    private javax.swing.JLabel jLDetalhamentoNome;
    private javax.swing.JLabel jLDetalhamentoPreco;
    private javax.swing.JLabel jLDetalhamentoPrimeiroCampoVariavel;
    private javax.swing.JLabel jLDetalhamentoQuantidade;
    private javax.swing.JLabel jLDetalhamentoSegundoCampoVariavel;
    private javax.swing.JLabel jLDetalhamentoTerceiroCampoVariavel;
    private javax.swing.JLabel jLDetalhamentoTipo;
    private javax.swing.JLabel jLImagem;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JLabel jLPrimeiroCampoVariavel;
    private javax.swing.JLabel jLQuantidade;
    private javax.swing.JLabel jLSegundoCampoVariavel;
    private javax.swing.JLabel jLTerceiroCampoVariavel;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JPanel jPCentral;
    // End of variables declaration//GEN-END:variables
}
