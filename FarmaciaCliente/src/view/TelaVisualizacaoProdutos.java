package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelDominio.Compra;
import modelDominio.Produto;
import modelDominio.Usuario;
import view.tablemodel.ProdutoTableModel;

public class TelaVisualizacaoProdutos extends javax.swing.JDialog {
    private ProdutoTableModel produtoTableModel;
    private ArrayList<Usuario> listaUsuarios;
    // Produto que será utilizado no Comprar
    private Produto produto;

    public TelaVisualizacaoProdutos() {
        initComponents();
        // Chamando o método que atualiza a tabela
        atualizaTabela();
        // Obtendo a lista de usuários
        listaUsuarios = FarmaciaCliente.ccont.usuarioLista();
        // Carregando a jCBUsuarios
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            jCBUsuarios.addItem(usuario.getNome() + " - " + usuario.getCpf());
        }
    }
    
    public void atualizaTabela() {
        // Obtendo a lista de Produtos
        ArrayList<Produto> listaProdutos = FarmaciaCliente.ccont.produtoLista();
        // Instanciando a tableModel com a lista
        produtoTableModel = new ProdutoTableModel(listaProdutos);
        // Definindo o tableModel da tabela
        jTProdutos.setModel(produtoTableModel);
        // Desabilitando os botões de compra
        jSQuantidadeCompra.setEnabled(false);
        jSQuantidadeCompra.setValue(1);
        jLQuantidadeDisponivel.setVisible(false);
        jCBUsuarios.setEnabled(false);
        jCBUsuarios.setSelectedIndex(0);
        jLPreçoCompra.setText("R$0,00");
        jBComprar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBarraMenu = new javax.swing.JPanel();
        jBVoltar = new javax.swing.JButton();
        jPLateral = new javax.swing.JPanel();
        jBComprar = new javax.swing.JButton();
        jLQuantidade = new javax.swing.JLabel();
        jLQuantidadeDisponivel = new javax.swing.JLabel();
        jLValorTotal = new javax.swing.JLabel();
        jLPreçoCompra = new javax.swing.JLabel();
        jLCliente = new javax.swing.JLabel();
        jSQuantidadeCompra = new javax.swing.JSpinner();
        jCBUsuarios = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Visualização de Produtos");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPBarraMenu.setBackground(new java.awt.Color(249, 249, 249));
        jPBarraMenu.setPreferredSize(new java.awt.Dimension(600, 46));
        jPBarraMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPBarraMenu.add(jBVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPBarraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 55));

        jPLateral.setBackground(new java.awt.Color(33, 31, 104));

        jBComprar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBComprar.setForeground(new java.awt.Color(33, 31, 104));
        jBComprar.setText("Comprar");
        jBComprar.setBorder(null);
        jBComprar.setBorderPainted(false);
        jBComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBComprar.setRequestFocusEnabled(false);
        jBComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBComprarActionPerformed(evt);
            }
        });

        jLQuantidade.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        jLQuantidade.setText("Quantidade:");

        jLQuantidadeDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLQuantidadeDisponivel.setForeground(new java.awt.Color(255, 255, 255));
        jLQuantidadeDisponivel.setText("jLQuantidadeDisponivel");

        jLValorTotal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLValorTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLValorTotal.setText("Valor total:");

        jLPreçoCompra.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLPreçoCompra.setForeground(new java.awt.Color(255, 255, 255));
        jLPreçoCompra.setText("jLPreçoCompra");

        jLCliente.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLCliente.setText("Cliente:");

        jSQuantidadeCompra.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSQuantidadeCompra.setBorder(null);
        jSQuantidadeCompra.setRequestFocusEnabled(false);
        jSQuantidadeCompra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSQuantidadeCompraStateChanged(evt);
            }
        });

        jCBUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        jCBUsuarios.setBorder(null);
        jCBUsuarios.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPLateralLayout = new javax.swing.GroupLayout(jPLateral);
        jPLateral.setLayout(jPLateralLayout);
        jPLateralLayout.setHorizontalGroup(
            jPLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLateralLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLateralLayout.createSequentialGroup()
                        .addComponent(jLQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLQuantidadeDisponivel))
                    .addComponent(jBComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPLateralLayout.createSequentialGroup()
                        .addComponent(jLValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPreçoCompra))
                    .addComponent(jCBUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCliente)
                    .addComponent(jSQuantidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPLateralLayout.setVerticalGroup(
            jPLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLateralLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLQuantidade)
                    .addComponent(jLQuantidadeDisponivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSQuantidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addGroup(jPLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorTotal)
                    .addComponent(jLPreçoCompra))
                .addGap(18, 18, 18)
                .addComponent(jBComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        getContentPane().add(jPLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 290, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTProdutos.setFocusable(false);
        jTProdutos.setGridColor(new java.awt.Color(255, 255, 255));
        jTProdutos.getTableHeader().setReorderingAllowed(false);
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
        // Habilitando os botões de compra
        jSQuantidadeCompra.setEnabled(true);
        jLQuantidadeDisponivel.setVisible(true);
        jCBUsuarios.setEnabled(true);
        jBComprar.setEnabled(true);
        // Obtendo o índice
        int indice = jTProdutos.getSelectedRow();
        // Obtendo o Produto
        Produto produto = produtoTableModel.getProduto(indice);
        // Instanciando o Produto
        this.produto = produto;
        // Carregando as informações
        jSQuantidadeCompra.setValue(1);
        jLQuantidadeDisponivel.setText("(" + produto.getQuantidade() + " disponível)");
        jLPreçoCompra.setText("R$" + produto.getPrecoString(produto.getPreco()));
        // Validação do duplo clique
        if (evt.getClickCount() == 2) {
            // Chamando a tela
            TelaDetalhamentoProdutos telaDetalhamentoProduto = new TelaDetalhamentoProdutos(produto);
            telaDetalhamentoProduto.setModal(true);
            telaDetalhamentoProduto.setVisible(true);
            // Atualização da tebela após saída da tela
            atualizaTabela();
        }
    }//GEN-LAST:event_jTProdutosMouseClicked

    private void jBComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBComprarActionPerformed
        // Validação das informações
        if (jCBUsuarios.getSelectedIndex() != 0) {
            // Confirmando a compra
            int resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja finalizar a compra", "Comprar", JOptionPane.YES_NO_OPTION);
            // Validação da resposta
            if (resposta == JOptionPane.YES_OPTION) {
                // Obtendo as informações
                Usuario usuario = listaUsuarios.get(jCBUsuarios.getSelectedIndex() - 1);
                LocalDate dataLocal = LocalDate.now();
                Date data = Date.valueOf(dataLocal);
                int quantidadeCompra = (Integer) jSQuantidadeCompra.getValue();
                float precoCompra = produto.getPreco() * quantidadeCompra;
                // Criando o objeto da classe Compra
                Compra compra = new Compra(produto, usuario, data, quantidadeCompra, precoCompra);
                // Enviando a solicitação de Compra ao servidor
                boolean resultado = FarmaciaCliente.ccont.compraInserir(compra);
                // Verificação do resultado
                if (resultado == true) {
                    JOptionPane.showMessageDialog(rootPane, "Compra realizada com sucesso.");
                    atualizaTabela();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível realizar a compra.");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: selecione um cliente.");
        }
    }//GEN-LAST:event_jBComprarActionPerformed

    private void jSQuantidadeCompraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSQuantidadeCompraStateChanged
        // Obtendo a quantidade da compra
        int quantidadeCompra = (Integer) jSQuantidadeCompra.getValue();
        // Validação da quantidade da compra
        if (quantidadeCompra <= produto.getQuantidade()) {
            jLPreçoCompra.setText("R$" + produto.getPrecoString(produto.getPreco() * quantidadeCompra));
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe uma quantidade válida.");
            jSQuantidadeCompra.setValue(produto.getQuantidade());
        }
    }//GEN-LAST:event_jSQuantidadeCompraStateChanged

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBComprar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBUsuarios;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JLabel jLPreçoCompra;
    private javax.swing.JLabel jLQuantidade;
    private javax.swing.JLabel jLQuantidadeDisponivel;
    private javax.swing.JLabel jLValorTotal;
    private javax.swing.JPanel jPBarraMenu;
    private javax.swing.JPanel jPLateral;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSQuantidadeCompra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    // End of variables declaration//GEN-END:variables
}
